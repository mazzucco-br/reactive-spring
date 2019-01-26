package com.mazzucco.reactivespring.mscontratos.repository.client.createUsuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ms-usuarios", fallback = UsuarioCreateFallback.class)
public interface UsuarioCreateClient {
	 @RequestMapping(method = RequestMethod.POST, value = "usuarios")
	 UsuarioCreateResponseDto create(UsuarioCreateRequestDto request);
}