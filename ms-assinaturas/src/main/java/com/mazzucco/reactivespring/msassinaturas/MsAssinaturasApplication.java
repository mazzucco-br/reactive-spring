package com.mazzucco.reactivespring.msassinaturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class MsAssinaturasApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MsAssinaturasApplication.class, args);
	}
}
