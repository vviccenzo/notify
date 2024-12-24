package com.api.emailNotify.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailSendDTO {

	private String emailSender;

	private String emailReceiver;

	private String emailBody;

}
