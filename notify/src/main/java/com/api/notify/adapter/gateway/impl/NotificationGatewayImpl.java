package com.api.notify.adapter.gateway.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.api.notify.adapter.dto.EmailNotificationDTO;
import com.api.notify.adapter.dto.NotificationDTO;
import com.api.notify.adapter.gateway.NotificationGateway;
import com.api.notify.adapter.gateway.NotificationRepositoryGateway;
import com.api.notify.adapter.mapper.NotificationMapper;
import com.api.notify.domain.Notification;
import com.api.notify.domain.enums.StatusType;
import com.api.notify.infrastructure.message.NotificationPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class NotificationGatewayImpl implements NotificationGateway {

	private final NotificationRepositoryGateway notificationRepositoryGateway;

	private final NotificationPublisher notificationPublisher;

	public NotificationGatewayImpl(NotificationRepositoryGateway notificationRepositoryGateway, NotificationPublisher notificationPublisher) {
		this.notificationRepositoryGateway = notificationRepositoryGateway;
		this.notificationPublisher = notificationPublisher;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public NotificationDTO send(NotificationDTO notificationDTO) throws JsonProcessingException {
		Notification notification = NotificationMapper.toNotificationFromNotificationDTO(notificationDTO);
		Notification savedNotification = this.notificationRepositoryGateway.save(notification);
		
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        EmailNotificationDTO emailToSend = new EmailNotificationDTO(notificationDTO.getSenderEmail(), notificationDTO.getReceiverEmail(), notificationDTO.getTitle(), notificationDTO.getContent());
        String notificationJson = objectMapper.writeValueAsString(emailToSend);
		String status = this.notificationPublisher.send("notificationExchange", "notification.email", notificationJson);

		savedNotification = NotificationMapper.updateNotificationFromStatusReceived(savedNotification, StatusType.valueOf(status));

		return NotificationMapper.toNotificationDTOFromNotification(savedNotification);
	}

}
