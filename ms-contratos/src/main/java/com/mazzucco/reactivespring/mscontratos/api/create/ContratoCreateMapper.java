package com.mazzucco.reactivespring.mscontratos.api.create;

import com.mazzucco.reactivespring.mscontratos.repository.entity.Contrato;

import reactor.core.publisher.Mono;

public interface ContratoCreateMapper {
	static Mono<ContratoCreateResponse> toContratoCreateResponse(Contrato contrato) {
		return Mono.just(ContratoCreateResponse.builder()
				.id(contrato.getId())
				.build()
			);
	}
	
	static ContratoCreateMessage toContratoCreateMessage(Contrato contrato) {
		return ContratoCreateMessage.builder()
				.id(contrato.getId())
				.data(contrato.getData())
				.descricao(contrato.getDescricao())
				.build();
	}
}