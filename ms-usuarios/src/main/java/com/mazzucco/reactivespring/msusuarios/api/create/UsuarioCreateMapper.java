package com.mazzucco.reactivespring.msusuarios.api.create;


import com.mazzucco.reactivespring.msusuarios.repository.entity.Usuario;

import reactor.core.publisher.Mono;

public interface UsuarioCreateMapper {
	static Mono<UsuarioCreateResponse> toAssinaturaCreateResponse(Usuario usuarios) {
		return Mono.just(UsuarioCreateResponse.builder()
				.id(usuarios.getId())
				.build()
			);
	}
}