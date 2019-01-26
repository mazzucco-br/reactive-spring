package com.mazzucco.reactivespring.mscontratos.repository.client.createUsuario;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class UsuarioCreateGrpc {
	@HystrixCommand(groupKey = "notification-service", fallbackMethod = "createFallback")
	public UsuarioCreateResponseDto create(UsuarioCreateRequestDto request) {
        /* Simulate some computing time */
        try {
            Thread.sleep((int) (Math.random() * 50) + 10);
        } catch (InterruptedException e) {
            // do nothing
        }

        /* Fail sometimes ...  */
        if (Math.random() > 0.99) {
            throw new RuntimeException("Random failure");
        }
		return null;
	}
	
	public UsuarioCreateResponseDto createFallback(UsuarioCreateRequestDto request) {
		return UsuarioCreateResponseDto.builder().build();
	}
}
