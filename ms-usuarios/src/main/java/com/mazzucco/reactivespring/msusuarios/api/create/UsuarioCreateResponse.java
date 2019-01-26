package com.mazzucco.reactivespring.msusuarios.api.create;


import com.mazzucco.reactivespring.mscommons.api.common.Payload;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class UsuarioCreateResponse implements Payload {
	String id;
}