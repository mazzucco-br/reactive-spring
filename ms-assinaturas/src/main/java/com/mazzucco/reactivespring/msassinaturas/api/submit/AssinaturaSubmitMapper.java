package com.mazzucco.reactivespring.msassinaturas.api.submit;


import com.mazzucco.reactivespring.msassinaturas.repositoy.entity.Assinatura;

import reactor.core.publisher.Mono;

public interface AssinaturaSubmitMapper {
	static Mono<AssinaturaSubmitResponse> toAssinaturaCreateResponse(Assinatura assinatura) {
		return Mono.just(AssinaturaSubmitResponse.builder()
				.id(assinatura.getId())
				.build()
			);
	}
}