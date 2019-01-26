package com.mazzucco.reactivespring.mscontratos.api.create;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazzucco.reactivespring.mscommons.api.common.BaseBusinessService;
import com.mazzucco.reactivespring.mscontratos.repository.ContratoRepository;
import com.mazzucco.reactivespring.mscontratos.repository.UsuarioRepository;
import com.mazzucco.reactivespring.mscontratos.repository.client.createUsuario.UsuarioCreateRequestDto;
import com.mazzucco.reactivespring.mscontratos.repository.entity.Contrato;
import com.mazzucco.reactivespring.mscontratos.service.mensagem.usuario.NotificacaoUsuarioMessage;
import com.mazzucco.reactivespring.mscontratos.service.mensagem.usuario.NotificacaoUsuarioService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.TopicProcessor;

@Service
@Slf4j
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ContratoCreateBusinessService extends BaseBusinessService<ContratoCreateRequest, ContratoCreateResponse> {
	
	@Autowired
	ContratoRepository contratosRepository;
	
    @Autowired
    TopicProcessor<String> contratosProcessor;
    
    @Autowired
    NotificacaoUsuarioService notificacaoUsuarioService;
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
	@Override
	protected Publisher<ContratoCreateResponse> execution(ContratoCreateRequest request) {
		return contratosRepository
			.save(Contrato.builder()
				.descricao(request.getDescricao())
				.build())
			.doOnNext(this::notificarWebSocket)
			.doOnNext(contrato -> this.validarUsuarios(request))
			.doOnNext(contrato -> this.notificarPartes(contrato, request))
			.doOnNext(contrato -> log.info("novo contrato: {}", contrato))
			.flatMap(ContratoCreateMapper::toContratoCreateResponse);
	}

	private void notificarPartes(Contrato contrato, ContratoCreateRequest request) {
		
		notificacaoUsuarioService.notificar(
			NotificacaoUsuarioMessage.builder()
				.nome(request.getResponsavel().getNome())
				.email(request.getResponsavel().getEmail())
				.cpf(request.getResponsavel().getCpf())
				.idContrato(contrato.getId())
				.descricaoContrato(contrato.getDescricao())
				.build());
		
		request.getSignatarios().forEach(sig -> 
			notificacaoUsuarioService.notificar(
				NotificacaoUsuarioMessage.builder()
					.nome(sig.getNome())
					.email(sig.getEmail())
					.cpf(sig.getCpf())
					.idContrato(contrato.getId())
					.descricaoContrato(contrato.getDescricao())
					.build()));
		
	}

	private void validarUsuarios(ContratoCreateRequest request) {
		request.getSignatarios().forEach(sig -> 
			usuarioRepository.create(
				UsuarioCreateRequestDto.builder()
				.nome(sig.getNome())
				.email(sig.getEmail())
				.cpf(sig.getCpf())
				.build()));

	}
	
	private void notificarWebSocket(Contrato contrato) {
		contratosProcessor.onNext(contrato.toString());
	}
	
	@Override
	protected Logger getLogger() {
		return log;
	}
}