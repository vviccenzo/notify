package com.api.emailNotify.adapter.dto;

import lombok.Data;

@Data
public class EmailNotificationDTO {

	private String senderEmail;

	private String receiverEmail;

	private String title;

	private String content;

}
