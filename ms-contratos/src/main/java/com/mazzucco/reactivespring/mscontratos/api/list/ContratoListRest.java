package com.mazzucco.reactivespring.mscontratos.api.list;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ContratoListRest {
	
	@Autowired
	ContratoListBusinessService createContratoBusinessService;
	
    @ResponseBody
    @GetMapping(value="contratos", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand
	public Publisher<ContratoListResponse> list() {
	    return createContratoBusinessService.execute(ContratoListRequest.builder().build());
	}
}
