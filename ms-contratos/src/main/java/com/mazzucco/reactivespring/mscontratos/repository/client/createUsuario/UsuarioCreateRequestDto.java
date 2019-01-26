package com.mazzucco.reactivespring.mscontratos.repository.client.createUsuario;

import com.mazzucco.reactivespring.mscommons.api.common.Payload;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class UsuarioCreateRequestDto implements Payload {
	String nome;
	String email;
	String cpf;
}