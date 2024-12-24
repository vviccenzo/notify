package com.api.emailNotify.infrastructure.message;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	public static final String NOTIFICATION_EXCHANGE = "notificationExchange";
	public static final String EMAIL_ROUTING_KEY = "notification.email";
	public static final String EMAIL_QUEUE = "emailQueue";

	@Bean
	public DirectExchange notificationExchange() {
		return new DirectExchange(NOTIFICATION_EXCHANGE);
	}

	@Bean
	public Queue emailQueue() {
		return new Queue(EMAIL_QUEUE, true);
	}

	@Bean
	public Binding emailBinding(Queue emailQueue, DirectExchange notificationExchange) {
		return BindingBuilder.bind(emailQueue).to(notificationExchange).with(EMAIL_ROUTING_KEY);
	}
}
