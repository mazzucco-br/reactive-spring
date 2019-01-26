package com.mazzucco.reactivespring.mscontratos.api.create;

import com.mazzucco.reactivespring.mscommons.api.common.Payload;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ContratoCreateResponse implements Payload {
	String id;
}
