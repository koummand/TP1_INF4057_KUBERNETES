package com.m1.fonda.NotificationRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.m1.fonda.model.Notification;

@RepositoryRestResource
public interface NotificationRepository extends JpaRepository<Notification, String> {

}
