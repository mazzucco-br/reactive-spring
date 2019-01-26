package com.mazzucco.reactivespring.msassinaturas.api.submit;

import java.time.LocalDateTime;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazzucco.reactivespring.msassinaturas.repositoy.AssinaturaRepository;
import com.mazzucco.reactivespring.mscommons.api.common.BaseBusinessService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AssinaturaSubmitBusinessService extends BaseBusinessService<AssinaturaSubmitRequest, AssinaturaSubmitResponse> {
	
	@Autowired
	AssinaturaRepository assinaturasRepository;
	
	@Override
	protected Publisher<AssinaturaSubmitResponse> execution(AssinaturaSubmitRequest request) {
		return assinaturasRepository.findById(request.getIdAssinatura())
		.doOnNext(assinatura -> {
			assinatura.setDataAssinatura(LocalDateTime.now());
			assinatura.setStatus("ASSINADO");
		}).flatMap(AssinaturaSubmitMapper::toAssinaturaCreateResponse);
	}

	@Override
	protected Logger getLogger() {
		return log;
	}
}