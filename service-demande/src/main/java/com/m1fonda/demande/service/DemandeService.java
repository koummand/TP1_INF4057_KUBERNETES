package com.m1fonda.demande.service;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.m1fonda.demande.DemandeRepository.DemandeRepository;
import com.m1fonda.demande.event.DemandeEvent;
import com.m1fonda.demande.model.Demande;

@Service
public class DemandeService {
@Autowired
private DemandeRepository demandeRepository;
@Autowired
private RabbitTemplate rabbitTemplate;

// envoie de la demande par l utilisateur
public void envoyerDemandeCreationCompte(Demande demande) {
try {
demande.setDateDemande(LocalDateTime.now().toString());
Demande demandeRepos = demandeRepository.save(demande);

DemandeEvent event = new DemandeEvent();

event.setClientId(demandeRepos.getClientId());
event.setNom(demandeRepos.getNom());
event.setCni(demandeRepos.getCni());
event.setPassword(demandeRepos.getPassword());
event.setDateDemande(demandeRepos.getDateDemande());
event.setPhoneNumber(demandeRepos.getPhoneNumber());
event.setTypeBanque(demandeRepos.getTypeBanque());
event.setAction(demandeRepos.getAction());


// Publier la demande dans la queue "userQueue"
rabbitTemplate.convertAndSend("demandeExchange", "demande.created", event);
System.out.println("Demande soumise : " + event);

} catch (Exception e) {
throw new RuntimeException("Error lors de l'envoie de la demande", e);

}
}
}
