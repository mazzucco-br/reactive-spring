package com.mazzucco.reactivespring.mscontratos.repository.client.createUsuario;

import org.springframework.stereotype.Component;

@Component
class UsuarioCreateFallback implements UsuarioCreateClient {
	@Override
	public UsuarioCreateResponseDto create(UsuarioCreateRequestDto request) {
		// TODO chamar fila
		return null;
	}
}