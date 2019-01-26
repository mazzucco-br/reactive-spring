package com.mazzucco.reactivespring.gateway;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {
	public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(GatewayServerApplication.class).web(true).run(args);
	}
}