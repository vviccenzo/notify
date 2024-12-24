package com.api.notify.adapter.dto;

import java.time.LocalDateTime;

import com.api.notify.domain.enums.NotificationType;
import com.api.notify.domain.enums.StatusType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

	private String id;

	private String title;
	
	private String senderEmail;
	
	private String receiverEmail;

	private String content;

	private LocalDateTime sentAt;

	private StatusType status;

	private NotificationType type;

}
