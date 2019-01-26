package com.mazzucco.reactivespring.msassinaturas.api.create;

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
public class AssinaturaCreateRest {
	
	@Autowired
	AssinaturaCreateBusinessService assinaturaCreateBusinessService;
	
    @ResponseBody
    @PostMapping(value="assinaturas", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand
	public Publisher<AssinaturaCreateResponse> create(@RequestBody @Valid AssinaturaCreateRequest request) {
	    return assinaturaCreateBusinessService.execute(request);
	}
}