package com.mazzucco.reactivespring.msassinaturas.api.create;


import com.mazzucco.reactivespring.msassinaturas.repositoy.entity.Assinatura;

import reactor.core.publisher.Mono;

public interface AssinaturaCreateMapper {
	static Mono<AssinaturaCreateResponse> toAssinaturaCreateResponse(Assinatura assinatura) {
		return Mono.just(AssinaturaCreateResponse.builder()
				.id(assinatura.getId())
				.build()
			);
	}
}