package com.api.notify.adapter.mapper;

import java.time.LocalDateTime;

import com.api.notify.adapter.dto.NotificationDTO;
import com.api.notify.domain.Notification;
import com.api.notify.domain.enums.StatusType;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NotificationMapper {

	public static Notification toNotificationFromNotificationDTO(NotificationDTO notificationDTO) {
		Notification notification = new Notification();
		notification.setContent(notificationDTO.getContent());
		notification.setTitle(notificationDTO.getTitle());
		notification.setType(notificationDTO.getType());
		notification.setSentAt(LocalDateTime.now());
		notification.setStatus(StatusType.SENT);

		return notification;
	}

	public static NotificationDTO toNotificationDTOFromNotification(Notification notification) {
		NotificationDTO notificationDTO = new NotificationDTO();
		notificationDTO.setId(notification.getId());
		notificationDTO.setContent(notification.getContent());
		notificationDTO.setTitle(notification.getTitle());
		notificationDTO.setType(notification.getType());
		notificationDTO.setSentAt(notification.getSentAt());
		notificationDTO.setStatus(notification.getStatus());

		return notificationDTO;
	}

	public static Notification updateNotificationFromStatusReceived(Notification notification, StatusType status) {
		notification.setUpdatedAt(LocalDateTime.now());
		notification.setStatus(status);

		return notification;
	}
}
