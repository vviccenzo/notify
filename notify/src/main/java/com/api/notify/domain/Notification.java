package com.api.notify.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.api.notify.domain.enums.NotificationType;
import com.api.notify.domain.enums.StatusType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Document(collection = "notification")
@EqualsAndHashCode(callSuper = true)
public class Notification extends GenericModel {

	private StatusType status;

	private NotificationType type;

	private String content;

	private String title;

	private LocalDateTime sentAt;

	private LocalDateTime updatedAt;

}
