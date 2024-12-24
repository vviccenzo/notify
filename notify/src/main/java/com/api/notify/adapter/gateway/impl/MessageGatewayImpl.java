package com.api.notify.adapter.gateway.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.api.notify.adapter.gateway.MessageGateway;

@Component
public class MessageGatewayImpl implements MessageGateway {

	private RabbitTemplate rabbitTemplate;

	public MessageGatewayImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public String send(String exchange, String routingKey, Object message) {
		
		this.rabbitTemplate.setReplyTimeout(15000);
		
		Message convertedMessage = this.rabbitTemplate.getMessageConverter().toMessage(message, new MessageProperties());

		Message response = this.rabbitTemplate.sendAndReceive(exchange, routingKey, convertedMessage);

		if (response != null) {
			return new String(response.getBody());
		}

		return null;
	}

}
