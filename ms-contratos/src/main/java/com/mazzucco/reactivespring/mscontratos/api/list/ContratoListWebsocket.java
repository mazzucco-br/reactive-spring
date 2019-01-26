package com.mazzucco.reactivespring.mscontratos.api.list;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ContratoListWebsocket implements WebSocketHandler {

	private static final ObjectMapper json = new ObjectMapper();

	private Flux<String> eventFlux = Flux.generate(sink -> {
		ContratoListResponse response = ContratoListResponse.builder().build();
		try {
			sink.next(json.writeValueAsString(response));
		} catch (JsonProcessingException e) {
			sink.error(e);
		}
	});

	private Flux<String> intervalFlux = Flux.interval(Duration.ofMillis(1000L))
			.zipWith(eventFlux, (time, event) -> event);

	@Override
	public Mono<Void> handle(WebSocketSession webSocketSession) {
		return webSocketSession.send(intervalFlux
				.map(webSocketSession::textMessage))
				.and(webSocketSession.receive()
						.map(WebSocketMessage::getPayloadAsText).log());
	}
}
