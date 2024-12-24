package com.api.emailNotify.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.api.emailNotify.domain.enums.StatusType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "email_notification")
public class EmailNotification extends GenericModel {

	private String senderEmail;

	private String receiverEmail;

	private String title;

	private String content;

	private LocalDateTime sentAt;

	private StatusType status;

}
