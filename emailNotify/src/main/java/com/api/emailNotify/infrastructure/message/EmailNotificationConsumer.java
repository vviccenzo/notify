package com.api.emailNotify.infrastructure.message;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.api.emailNotify.application.usecase.ConsumeEmailNotificationUseCase;

@Component
public class EmailNotificationConsumer {

	private final ConsumeEmailNotificationUseCase consumeEmailNotificationUseCase;

	public EmailNotificationConsumer(ConsumeEmailNotificationUseCase consumeEmailNotificationUseCase) {
		this.consumeEmailNotificationUseCase = consumeEmailNotificationUseCase;
	}

	@RabbitListener(bindings = @QueueBinding(
		value = @Queue(value = "emailQueue", durable = "true"),
		exchange = @Exchange(value = "notificationExchange", type = ExchangeTypes.DIRECT),
		key = "email.notification"
	))
	public String consumeMessage(String message) {
		return this.consumeEmailNotificationUseCase.execute(message);
	}

}
