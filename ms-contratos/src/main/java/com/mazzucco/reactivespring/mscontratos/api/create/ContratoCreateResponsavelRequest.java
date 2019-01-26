package com.mazzucco.reactivespring.mscontratos.api.create;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ContratoCreateResponsavelRequest {
	@NotBlank
	String nome;
	@Email
	String email;
	@CPF
	String cpf;
}
