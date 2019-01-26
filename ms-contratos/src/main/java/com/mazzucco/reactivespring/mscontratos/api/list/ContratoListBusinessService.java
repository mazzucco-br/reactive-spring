package com.mazzucco.reactivespring.mscontratos.api.list;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazzucco.reactivespring.mscommons.api.common.BaseBusinessService;
import com.mazzucco.reactivespring.mscontratos.repository.ContratoRepository;
import com.mazzucco.reactivespring.mscontratos.repository.entity.Contrato;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ContratoListBusinessService extends BaseBusinessService<ContratoListRequest, ContratoListResponse> {

	@Autowired
	private ContratoRepository contratoRepository;

	@Override
	protected Publisher<ContratoListResponse> execution(ContratoListRequest request) {
		return contratoRepository
			.findAll()
			.flatMap(this::toResponse);
	}

	private Mono<ContratoListResponse> toResponse(Contrato contrato) {
		return Mono.just(ContratoListResponse.builder()
				.id(contrato.getId())
				.data(contrato.getData())
				.descricao(contrato.getDescricao())
				.build()
			);
	}

	@Override
	protected Logger getLogger() {
		return log;
	}
}