package com.api.notify.infrastructure.message;

import org.springframework.stereotype.Component;

import com.api.notify.adapter.gateway.MessageGateway;

@Component
public class NotificationPublisher {

	private final MessageGateway messageGateway;

	public NotificationPublisher(MessageGateway messageGateway) {
		this.messageGateway = messageGateway;
	}

	public String send(String exchange, String routingKey, Object message) {
		return this.messageGateway.send(exchange, routingKey, message);
	}

}
