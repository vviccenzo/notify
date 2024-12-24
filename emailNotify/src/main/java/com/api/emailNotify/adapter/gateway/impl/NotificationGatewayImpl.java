package com.api.emailNotify.adapter.gateway.impl;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Component;

import com.api.emailNotify.adapter.dto.EmailNotificationDTO;
import com.api.emailNotify.adapter.dto.EmailSendDTO;
import com.api.emailNotify.adapter.gateway.NotificationGateway;
import com.api.emailNotify.application.shared.validation.EmailUtils;
import com.api.emailNotify.application.usecase.EmailSendUsecase;
import com.api.emailNotify.infrastructure.template.EmailTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.mail.MessagingException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class NotificationGatewayImpl implements NotificationGateway {

	private static final String STATUS_CODE_FAILED = "FAILED";

	private final EmailSendUsecase emailSendUsecase;

	public NotificationGatewayImpl(EmailSendUsecase emailSendUsecase) {
		this.emailSendUsecase = emailSendUsecase;
	}

	@Override
	public String consumeNotification(String message) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			EmailNotificationDTO notification = objectMapper.readValue(message, EmailNotificationDTO.class);
			if (!EmailUtils.isValidEmail(notification.getReceiverEmail())) {
				log.info("Email do destinatário inválido.");
				return STATUS_CODE_FAILED;
			}

			if (!EmailUtils.isValidEmail(notification.getSenderEmail())) {
				log.info("Email do remetente inválido.");
				return STATUS_CODE_FAILED;
			}

			String emailSender = notification.getSenderEmail();
			String emailReceiver = notification.getReceiverEmail();

			String title = notification.getTitle();
			String content = notification.getContent();
			String emailBody = EmailTemplate.generateEmailTemplate(title, content);

			CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
				try {
					this.emailSendUsecase.execute(new EmailSendDTO(emailSender, emailReceiver, emailBody));
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			});

			future.get();
		} catch (Exception e) {
			e.printStackTrace();

			return STATUS_CODE_FAILED;
		}

		return "DELIVERED";
	}

}
