package com.mazzucco.reactivespring.mscontratos.api.create;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.mazzucco.reactivespring.mscommons.api.common.Payload;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ContratoCreateRequest implements Payload {
	@NotBlank
	String descricao;
	
	@NotNull
	@Valid
	ContratoCreateResponsavelRequest responsavel;
	
	@NotNull
	@Valid
	List<ContratoCreateSignatarioRequest> signatarios;
}