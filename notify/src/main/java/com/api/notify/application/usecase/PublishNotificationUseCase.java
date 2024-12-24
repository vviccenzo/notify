package com.api.notify.application.usecase;

import org.springframework.stereotype.Component;

import com.api.notify.adapter.dto.NotificationDTO;
import com.api.notify.adapter.gateway.NotificationGateway;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class PublishNotificationUseCase {

	private NotificationGateway notificationGateway;

	public PublishNotificationUseCase(NotificationGateway notificationGateway) {
		this.notificationGateway = notificationGateway;
	}

	public NotificationDTO execute(NotificationDTO notificationDTO) throws JsonProcessingException {
		return this.notificationGateway.send(notificationDTO);
	}

}
