package com.mazzucco.reactivespring.msassinaturas.api.create;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazzucco.reactivespring.msassinaturas.repositoy.AssinaturaRepository;
import com.mazzucco.reactivespring.msassinaturas.repositoy.entity.Assinatura;
import com.mazzucco.reactivespring.msassinaturas.repositoy.entity.Signatario;
import com.mazzucco.reactivespring.mscommons.api.common.BaseBusinessService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AssinaturaCreateBusinessService extends BaseBusinessService<AssinaturaCreateRequest, AssinaturaCreateResponse> {
	
	@Autowired
	AssinaturaRepository assinaturasRepository;
	
    
	@Override
	protected Publisher<AssinaturaCreateResponse> execution(AssinaturaCreateRequest request) {
		return assinaturasRepository
			.save(Assinatura.builder()
				.idContrato(request.getIdContrato())
				.signatario(Signatario.builder()
						.cpf(request.getCpf())
						.email(request.getEmail())
						.nome(request.getNome())
						.build())
				.status("PENDENTE")
				.build())
			.flatMap(AssinaturaCreateMapper::toAssinaturaCreateResponse);
	}

	@Override
	protected Logger getLogger() {
		return log;
	}
}