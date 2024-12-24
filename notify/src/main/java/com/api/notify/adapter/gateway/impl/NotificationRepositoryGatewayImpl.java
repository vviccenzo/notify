package com.api.notify.adapter.gateway.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.api.notify.adapter.gateway.NotificationRepositoryGateway;
import com.api.notify.domain.Notification;
import com.api.notify.infrastructure.repository.NotificationRepository;

@Component
public class NotificationRepositoryGatewayImpl implements NotificationRepositoryGateway {

	public final NotificationRepository notificationRepository;

	public NotificationRepositoryGatewayImpl(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Notification save(Notification notification) {
		return this.notificationRepository.save(notification);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Notification update(Notification notification) {
		return this.notificationRepository.save(notification);
	}

}
