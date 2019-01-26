package com.mazzucco.reactivespring.msassinaturas.api.submit;

import com.mazzucco.reactivespring.mscommons.api.common.Payload;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AssinaturaSubmitRequest implements Payload {
	String idAssinatura;
	String token;
}