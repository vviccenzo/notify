package com.api.notify.adapter.gateway;

import com.api.notify.adapter.dto.NotificationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface NotificationGateway {

	public NotificationDTO send(NotificationDTO notificationDTO) throws JsonProcessingException;

}
