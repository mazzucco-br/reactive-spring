package com.mazzucco.reactivespring.msusuarios.client.msTwo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ms-contratos", fallback = MicroserviceTwoFallback.class)
public interface IMicroserviceTwoClient {
	 @RequestMapping(method = RequestMethod.GET, value = "/contratos/search")
	 ResponseTwo testCallTwo();
}
