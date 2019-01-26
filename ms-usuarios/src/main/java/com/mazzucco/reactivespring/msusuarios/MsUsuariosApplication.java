package com.mazzucco.reactivespring.msusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableHystrix
@EnableFeignClients
//@EnableEurekaClient  
//@EnableDiscoveryClient
@SpringBootApplication
public class MsUsuariosApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MsUsuariosApplication.class, args);
	}
}
