package com.mazzucco.reactivespring.msassinaturas.api.submit;

import javax.validation.Valid;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AssinaturaSubmitRest {
	
	@Autowired
	AssinaturaSubmitBusinessService assinaturaSubmitBusinessService;
	
    @ResponseBody
    @PutMapping(value="assinaturas", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand
	public Publisher<AssinaturaSubmitResponse> create(@RequestBody @Valid AssinaturaSubmitRequest request) {
	    return assinaturaSubmitBusinessService.execute(request);
	}
}