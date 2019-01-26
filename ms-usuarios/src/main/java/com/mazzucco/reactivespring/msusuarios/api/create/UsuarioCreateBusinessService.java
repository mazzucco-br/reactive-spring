package com.mazzucco.reactivespring.msusuarios.api.create;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazzucco.reactivespring.mscommons.api.common.BaseBusinessService;
import com.mazzucco.reactivespring.msusuarios.repository.UsuarioRepository;
import com.mazzucco.reactivespring.msusuarios.repository.entity.Usuario;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@FieldDefaults(level=AccessLevel.PRIVATE)
public class UsuarioCreateBusinessService extends BaseBusinessService<UsuarioCreateRequest, UsuarioCreateResponse> {
	
	@Autowired
	UsuarioRepository usuariossRepository;
	
    
	@Override
	protected Publisher<UsuarioCreateResponse> execution(UsuarioCreateRequest request) {
		return usuariossRepository
			.save(Usuario.builder()
				.cpf(request.getCpf())
				.email(request.getEmail())
				.nome(request.getNome())
				.build())
			.flatMap(UsuarioCreateMapper::toAssinaturaCreateResponse);
	}

	@Override
	protected Logger getLogger() {
		return log;
	}
}