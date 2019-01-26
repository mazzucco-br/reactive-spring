package com.mazzucco.reactivespring.mscontratos.service.mensagem.usuario;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level=AccessLevel.PRIVATE)
public class NotificacaoUsuarioService {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void notificar(@Payload NotificacaoUsuarioMessage message) {
		rabbitTemplate.convertAndSend("notificacao-email", message);
	}
}