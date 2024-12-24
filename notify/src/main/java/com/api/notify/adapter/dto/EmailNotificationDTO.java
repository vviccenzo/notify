package com.api.notify.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailNotificationDTO {

	private String senderEmail;

	private String receiverEmail;

	private String title;

	private String content;

}