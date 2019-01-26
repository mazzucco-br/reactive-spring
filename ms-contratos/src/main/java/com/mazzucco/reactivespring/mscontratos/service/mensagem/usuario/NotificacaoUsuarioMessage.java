package com.mazzucco.reactivespring.mscontratos.service.mensagem.usuario;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class NotificacaoUsuarioMessage {
	String nome;
	String email;
	String cpf;
	String descricaoContrato;
	String idContrato;
}