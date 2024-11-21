package com.m1.fonda.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1.fonda.NotificationRepository.NotificationRepository;
import com.m1.fonda.event.NotificationEvent;
import com.m1.fonda.model.Notification;

@Service
public class NotificationService {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private NotificationRepository notificationRepository;

	public void processNotification(NotificationEvent event, String source) {
		try {
			Notification notification = new Notification();

			notification.setTelephone(event.getTelephone());
			notification.setClientId(event.getClientId());
			notification.setMessage(event.getMessage());
			notification.setDate(LocalDateTime.now().toString());
			notification.setStatus(event.getStatus());

			notificationRepository.save(notification);

// publie la notification vers le client
			System.out.println("Envoi de la notification depuis " + source + " au service utilisateur : " + event);
			rabbitTemplate.convertAndSend("notificationExchange", "notification.created", event);
		} catch (Exception e) {
			System.err.println("Erreur lors du traitement de la notification pour la source : " + source);
			e.printStackTrace();
			throw new RuntimeException("Échec du traitement de la notification", e);
		}

	}

	public List<Notification> getAllNotification() {
		return notificationRepository.findAll();
	}
	
	public List<Notification> getAllNotificationByclient(int clientId) {
        return notificationRepository.findByClientId(clientId);
    }

}
