package com.m1fonda.demande.demanBroquer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.m1fonda.demande.event.UserEvent;
import com.m1fonda.demande.model.Userbanque;

@Service
public class DemandeConsumer {
	
	@RabbitListener(queues = "userQueue")
	public void receiveUserEvent(UserEvent event) {
		try {

			Userbanque userbanque = new Userbanque();

			userbanque.setUserName(event.getUserName());
			userbanque.setPassword(event.getPassword());
			userbanque.setCni(event.getCni());
			userbanque.setEmail(event.getEmail());
			userbanque.setPhoneNumber(event.getPhoneNumber());

		} catch (Exception e) {
			System.err.println("erreur l'or du traitement de l'évenement:" + e.getMessage());
			throw new RuntimeException(e);
		}
	}


}
