package com.m1.fonda.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1.fonda.event.CompteEvent;
import com.m1.fonda.event.NotificationEvent;
import com.m1.fonda.event.TransactionEvent;
import com.m1.fonda.model.Compte;
import com.m1.fonda.repository.CompteRepository;

import jakarta.transaction.Transactional;


@Service
public class CompteService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private CompteRepository comteRepository;

	public Compte creerComptes(int userId, String bankType) {
		String accountId = userId + "_" + bankType + "_account";
		Compte compte = new Compte();
		compte.setAccount_id(accountId);
		compte.setClientId(userId);
		compte.setTypeBanque(bankType);

		Compte compterepos = comteRepository.save(compte);

		CompteEvent event = new CompteEvent();
		event.setAccount_id(compterepos.getAccount_id());
		event.setClientId(compterepos.getClientId());
		event.setTypeBanque(compterepos.getTypeBanque());
		event.setSolde(compterepos.getSolde());

		System.out.println("compte creer avec succes " + event);

		NotificationEvent notificationEvent = new NotificationEvent();
		notificationEvent.setAccount_id(compterepos.getAccount_id());
		notificationEvent.setClientId(compterepos.getClientId());
		notificationEvent.setDate(LocalDateTime.now().toString());
		notificationEvent.setStatus("VALIDÉ");
		notificationEvent.setMessage("compte creer avec succes");

		System.out.println("envoie de notification au service de notification " + notificationEvent);
		rabbitTemplate.convertAndSend("compteExchange", "compte.created", notificationEvent);
		return compterepos;
	}

    @Transactional
    public float getSolde(String accountId) {
        return comteRepository.findById(accountId)
                .orElseThrow(() -> new NoSuchElementException(" impossible d'obtenir le solde Compte non trouvé pour l'ID " + accountId))
                .getSolde();
    }

	
	@Transactional
    public void miseAJourSolde(String accountId, float montant) {
        Compte compte = comteRepository.findById(accountId)
                .orElseThrow(() -> new NoSuchElementException("impossible de mettre a jour le solde Compte non trouvé pour l'ID " + accountId));
        
         float nouveauSolde = compte.getSolde() + montant;
	    
	    // Vérification supplémentaire pour éviter les soldes négatifs
	    if (nouveauSolde < 0) {
	        throw new IllegalArgumentException("Solde insuffisant pour effectuer cette opération.");
	    }
        compte.miseAjourSolde(montant);
//		comteRepository.updateBalance(montant, accountId);
        comteRepository.save(compte); // Sauvegarde explicite du solde mis à jour
    }

	public void effectuerDepot(TransactionEvent transactionEvent) {
		String accountId = transactionEvent.getAccount_id();
		float montant = transactionEvent.getMontant();
		
		

			this.miseAJourSolde(accountId, montant);
//			comteRepository.updateBalance(montant, accountId);
			
			float nouveauSolde = comteRepository.findById(accountId)
			        .orElseThrow(() -> new NoSuchElementException("Compte non trouvé pour l'ID " + accountId))
			        .getSolde();

			Compte compte = comteRepository.findById(accountId).orElseThrow(() -> new NoSuchElementException(
					"impossible de faire le depos Compte non trouvé pour l'ID " + accountId));
			int clientId = compte.getClientId();

// notifier le client
			NotificationEvent notificationEvent = new NotificationEvent();
			notificationEvent.setAccount_id(accountId);
			notificationEvent.setClientId(clientId);
			notificationEvent.setDate(LocalDateTime.now().toString());
			notificationEvent.setStatus("VALIDÉ");
			notificationEvent.setMessage(
					"l'operation de depot de " + montant + " a reuissit votre nouveau solde est de: " + nouveauSolde);

			System.out.println(
					"l'operation de depot de " + montant + " a reuissit votre nouveau solde est de: " + nouveauSolde);
			rabbitTemplate.convertAndSend("transactionExchange", "transaction.created", notificationEvent);	

	}
	

	public void effectuerRetrait(TransactionEvent transactionEvent) {
		String accountId = transactionEvent.getAccount_id();
		float montant = transactionEvent.getMontant();
		
		Compte compte = comteRepository.findById(accountId).orElseThrow(() -> new NoSuchElementException(
				"impossible de faire le retrait Compte non trouvé pour l'ID " + accountId));


			float soldeActuel = this.getSolde(accountId);
			
			NotificationEvent notificationEvent = new NotificationEvent();
			int clientId = compte.getClientId();

			if (soldeActuel >= montant) {

				this.miseAJourSolde(accountId, -montant);
//				comteRepository.updateBalance(montant, accountId);

				float nouveauSolde = comteRepository.findById(accountId)
				        .orElseThrow(() -> new NoSuchElementException("Compte non trouvé pour l'ID " + accountId))
				        .getSolde();

// notifier le client
				notificationEvent.setAccount_id(accountId);
				notificationEvent.setClientId(clientId);
				notificationEvent.setDate(LocalDateTime.now().toString());
				notificationEvent.setStatus("VALIDÉ");
				notificationEvent.setMessage("l'operation de retrait de " + montant
						+ " a reuissit votre nouveau solde est de: " + nouveauSolde);
				System.out.println("l'operation de retrait de " + montant + " a reuissit votre nouveau solde est de: "
						+ nouveauSolde);
				rabbitTemplate.convertAndSend("transactionExchange", "transaction.created", notificationEvent);

			} else {
				notificationEvent.setAccount_id(accountId);
				notificationEvent.setClientId(clientId);
				notificationEvent.setDate(LocalDateTime.now().toString());
				notificationEvent.setStatus("REFUSÉ");
				notificationEvent.setMessage("Solde insuffisant");

				System.out.println("Solde insuffisant");
				rabbitTemplate.convertAndSend("transactionExchange", "transaction.created", notificationEvent);
			}
		
	}
}
