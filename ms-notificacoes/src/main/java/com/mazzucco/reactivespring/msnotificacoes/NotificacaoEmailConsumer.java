package com.mazzucco.reactivespring.msnotificacoes;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificacaoEmailConsumer {
 
	@RabbitListener(queues="notificacao-email")
	public void recievedMessage(@Payload NotificacaoUsuarioMessage message) {
		log.info("enviando email para {} em {}, CPF: {}, assunto: {}, contrato: {}", message.getNome(),
				message.getEmail(), message.getCpf(), message.getDescricaoContrato(), message.getIdContrato());
	}
}