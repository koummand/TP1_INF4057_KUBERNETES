package com.m1.fonda.notificationBroquer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.m1.fonda.event.NotificationEvent;
import com.m1.fonda.service.NotificationService;

@Service
public class NotificationConsumer {
@Autowired
private NotificationService notificationService;


@RabbitListener(queues = "compteQueue")
public void receiveNotificationCompte(NotificationEvent event) {

notificationService.processNotification(event, "compte");

}

@RabbitListener(queues = "banqueQueue")
public void receiveNotificationBanque(NotificationEvent event) {

notificationService.processNotification(event, "banque");

}

@RabbitListener(queues = "transactionQueue")
public void receiveNotificationTransaction(NotificationEvent event) {

notificationService.processNotification(event, "transaction");

}
}
