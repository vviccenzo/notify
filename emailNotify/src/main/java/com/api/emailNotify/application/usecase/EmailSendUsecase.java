package com.api.emailNotify.application.usecase;

import org.springframework.stereotype.Component;

import com.api.emailNotify.adapter.dto.EmailSendDTO;
import com.api.emailNotify.adapter.gateway.EmailSendGateway;

import jakarta.mail.MessagingException;

@Component
public class EmailSendUsecase {

	private final EmailSendGateway emailSendGateway;
	
	public EmailSendUsecase(EmailSendGateway emailSendGateway) {
		this.emailSendGateway = emailSendGateway;
	}
	
	public void execute(EmailSendDTO emailSendDTO) throws MessagingException {
		this.emailSendGateway.sendEmail(emailSendDTO);
	}
}
