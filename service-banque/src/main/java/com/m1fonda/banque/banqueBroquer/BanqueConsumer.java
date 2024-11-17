package com.m1fonda.banque.banqueBroquer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1fonda.banque.event.DemandeEvent;
import com.m1fonda.banque.event.NotificationEvent;
import com.m1fonda.banque.model.Demande;
import com.m1fonda.banque.service.BanqueService;

@Service
public class BanqueConsumer {
@Autowired
private RabbitTemplate rabbitTemplate;

@Autowired
private BanqueService banqueService;

@RabbitListener(queues = "demandeQueue")
public void validerDemande(DemandeEvent event) {

Demande demande = new Demande();
demande.setClientId(event.getClientId());
demande.setCni(event.getCni());
demande.setDateDemande(event.getDateDemande());
demande.setPassword(event.getPassword());
demande.setNom(event.getNom());
demande.setPhoneNumber(event.getPhoneNumber());
demande.setTypeBanque(event.getTypeBanque());

System.out.println("Demande reçue pour validation : " + event);

boolean isValid = banqueService.validerDemande(event);// Logique de validation

if (isValid) {
banqueService.creerCompte(demande.getClientId(), demande.getTypeBanque());

} else {
NotificationEvent notificationEvent = new NotificationEvent();

notificationEvent.setAccount_id(null);
notificationEvent.setClientId(event.getClientId());
notificationEvent.setMessage("le compte n'a pas ete creer veillez verifier vos information");
notificationEvent.setDate(LocalDateTime.now().toString());
notificationEvent.setStatus("REFUSÉ");

System.out.println("envoie de notification au service de notification "+ notificationEvent);
rabbitTemplate.convertAndSend("banqueExchange", "banque.created", notificationEvent);// publication pour la
// creation

}

}

}
