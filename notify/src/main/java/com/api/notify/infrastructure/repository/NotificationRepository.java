package com.api.notify.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.notify.domain.Notification;

public interface NotificationRepository extends MongoRepository<Notification, Long> {

}
