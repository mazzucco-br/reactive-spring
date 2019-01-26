package com.mazzucco.reactivespring.msnotificacoes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class NotificacaoUsuarioMessage {
	String nome;
	String email;
	String cpf;
	String descricaoContrato;
	String idContrato;
}