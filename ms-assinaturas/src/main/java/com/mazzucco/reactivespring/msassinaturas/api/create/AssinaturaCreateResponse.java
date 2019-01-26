package com.mazzucco.reactivespring.msassinaturas.api.create;


import com.mazzucco.reactivespring.mscommons.api.common.Payload;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AssinaturaCreateResponse implements Payload {
	String id;
}