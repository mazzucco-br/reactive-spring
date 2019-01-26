package com.mazzucco.reactivespring.mscontratos.api.create;

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
public class ContratoCreateRest {
	
	@Autowired
	ContratoCreateBusinessService createContratoBusinessService;
	
    @ResponseBody
    @PostMapping(value="contratos", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand
	public Publisher<ContratoCreateResponse> create(@RequestBody @Valid ContratoCreateRequest request) {
	    return createContratoBusinessService.execute(request);
	}
}