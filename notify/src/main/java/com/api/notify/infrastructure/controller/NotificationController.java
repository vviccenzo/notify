package com.api.notify.infrastructure.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.notify.adapter.dto.NotificationDTO;
import com.api.notify.application.usecase.PublishNotificationUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	private final PublishNotificationUseCase notificationSendUseCase;

	public NotificationController(PublishNotificationUseCase notificationSendUseCase) {
		this.notificationSendUseCase = notificationSendUseCase;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public NotificationDTO sendNotification(@RequestBody NotificationDTO notificationDTO) throws JsonProcessingException {
		return this.notificationSendUseCase.execute(notificationDTO);
	}

}
