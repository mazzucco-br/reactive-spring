package com.mazzucco.reactivespring.msusuarios.api.create;

import javax.validation.Valid;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level=AccessLevel.PRIVATE)
public class UsuarioCreateRest {
	
	@Autowired
	UsuarioCreateBusinessService usuarioCreateBusinessService;
	
    @ResponseBody
    @PostMapping(value="usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand
	public Publisher<UsuarioCreateResponse> create(@RequestBody @Valid UsuarioCreateRequest request) {
	    return usuarioCreateBusinessService.execute(request);
	}
}