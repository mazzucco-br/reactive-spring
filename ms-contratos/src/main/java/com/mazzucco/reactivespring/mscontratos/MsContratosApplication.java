package com.mazzucco.reactivespring.mscontratos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
//@EnableEurekaClient
@EnableHystrixDashboard
@EnableHystrix
//@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients
@ComponentScan("com.mazzucco.reactivespring")
public class MsContratosApplication {
	public static void main(String[] args) throws Exception {
        final SpringApplication application = new SpringApplication(MsContratosApplication.class);
        //application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
	}
}
