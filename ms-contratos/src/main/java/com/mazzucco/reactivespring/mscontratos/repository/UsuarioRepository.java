package com.mazzucco.reactivespring.mscontratos.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mazzucco.reactivespring.mscontratos.repository.client.createUsuario.UsuarioCreateClient;
import com.mazzucco.reactivespring.mscontratos.repository.client.createUsuario.UsuarioCreateRequestDto;
import com.mazzucco.reactivespring.mscontratos.repository.client.createUsuario.UsuarioCreateResponseDto;

@Repository
public class UsuarioRepository {
	@Autowired
	private UsuarioCreateClient usuarioCreateClient;
	
	public UsuarioCreateResponseDto create(UsuarioCreateRequestDto request) {
		return usuarioCreateClient.create(request);
	}
}
