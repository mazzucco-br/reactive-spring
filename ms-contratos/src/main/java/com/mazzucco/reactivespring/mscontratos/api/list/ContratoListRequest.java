package com.mazzucco.reactivespring.mscontratos.api.list;

import com.mazzucco.reactivespring.mscommons.api.common.Payload;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ContratoListRequest implements Payload {
	String descricao;
}