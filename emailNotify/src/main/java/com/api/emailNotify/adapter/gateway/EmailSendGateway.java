package com.api.emailNotify.adapter.gateway;

import com.api.emailNotify.adapter.dto.EmailSendDTO;

import jakarta.mail.MessagingException;

public interface EmailSendGateway {

	public void sendEmail(EmailSendDTO emailSendDTO) throws MessagingException;
	
}
