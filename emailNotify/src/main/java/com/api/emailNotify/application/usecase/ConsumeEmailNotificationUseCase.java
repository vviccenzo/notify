package com.api.emailNotify.application.usecase;

import org.springframework.stereotype.Component;

import com.api.emailNotify.adapter.gateway.NotificationGateway;

@Component
public class ConsumeEmailNotificationUseCase {

	private final NotificationGateway notificationGateway;

	public ConsumeEmailNotificationUseCase(NotificationGateway noficationGateway) {
		this.notificationGateway = noficationGateway;
	}

	public String execute(String message) {
		return this.notificationGateway.consumeNotification(message);
	}
}
