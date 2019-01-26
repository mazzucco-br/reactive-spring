package com.mazzucco.reactivespring.mscontratos.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.TopicProcessor;

@Slf4j
@Configuration
public class WebSocketConfig {

	@Autowired
	private WebSocketHandler webSocketHandler;
	
	@Bean
	public TopicProcessor<String> contratosProcessor() {
		return TopicProcessor.create();
	}
	
	@Bean
    WebSocketHandlerAdapter socketHandlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
	
    @Bean
    ApplicationRunner appRunner() {
        return args -> contratosProcessor();
    }
	
	@Bean
    public WebSocketHandler webSocketHandler() {
        return session ->
                session.send(contratosProcessor()
                		.map(session::textMessage))
                        .onTerminateDetach()
                        .doOnSubscribe(sub -> log.info(session.getId() + " OPEN."))
                        .and(
                                session.receive()
                                        .map(WebSocketMessage::getPayloadAsText)
                                        .doOnNext(System.out::println)
                                        .doFinally(sig -> log.info(session.getId() + " CLOSE."))
                        );
    }

    @Bean
    HandlerMapping simpleUrlHandlerMapping(Flux<String> publisher) {
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setUrlMap(Collections.singletonMap("/ws/contratos", webSocketHandler()));
        simpleUrlHandlerMapping.setOrder(10);
        return simpleUrlHandlerMapping;
    }
}
