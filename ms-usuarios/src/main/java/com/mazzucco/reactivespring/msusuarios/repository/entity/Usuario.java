package com.mazzucco.reactivespring.msusuarios.repository.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Document
public class Usuario {
    @Id 
    String id;
	String nome;
	String email;
	String cpf;
	@Builder.Default
	LocalDateTime dataCadastro = LocalDateTime.now();
}