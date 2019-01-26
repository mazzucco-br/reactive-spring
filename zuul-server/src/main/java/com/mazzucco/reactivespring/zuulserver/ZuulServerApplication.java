package com.mazzucco.reactivespring.zuulserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

import com.github.mthizo247.cloud.netflix.zuul.web.socket.EnableZuulWebSocket;

@SpringBootApplication
@Controller
@EnableZuulProxy
@EnableZuulWebSocket
public class ZuulServerApplication {
	public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ZuulServerApplication.class).web(true).run(args);
	}
}
