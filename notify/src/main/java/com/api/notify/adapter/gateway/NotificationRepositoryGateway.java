package com.api.notify.adapter.gateway;

import com.api.notify.domain.Notification;

public interface NotificationRepositoryGateway {

	public Notification save(Notification notification);

	public Notification update(Notification notification);

}
