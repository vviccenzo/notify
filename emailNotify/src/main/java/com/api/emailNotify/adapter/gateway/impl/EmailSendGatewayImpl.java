package com.api.emailNotify.adapter.gateway.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.api.emailNotify.adapter.dto.EmailSendDTO;
import com.api.emailNotify.adapter.gateway.EmailSendGateway;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSendGatewayImpl implements EmailSendGateway {

	private final JavaMailSender mailSender;

	public EmailSendGatewayImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@Override
	public void sendEmail(EmailSendDTO dto) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(dto.getEmailReceiver());
        helper.setSubject(dto.getEmailSender());
        helper.setText(dto.getEmailBody(), true);
        helper.setFrom(dto.getEmailSender());

        this.mailSender.send(mimeMessage);
	}

}
