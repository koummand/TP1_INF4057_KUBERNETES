package com.m1.fonda.service;

import java.math.BigDecimal;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1.fonda.event.TransactionEvent;
import com.m1.fonda.model.Transaction;
import com.m1.fonda.transactionRepository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private TransactionRepository transactionRepository;

	public Transaction effectuerDepot(String telephone, float montant) throws Exception {
		if (telephone == null) {
			throw new IllegalArgumentException("Événement de depot invalide.");
		}
// Crée et enregistre la transaction
		Transaction transaction = new Transaction();
		transaction.setTelephone(telephone);
		transaction.setMontant(montant);
		transaction.setType_transaction("DEPOSIT");

		Transaction transactionrepos = transactionRepository.save(transaction);

		TransactionEvent transactionEvent = new TransactionEvent();

		transactionEvent.setTransaction_id(transactionrepos.getTransaction_id());
		transactionEvent.setTelephone(transactionrepos.getTelephone());
		transactionEvent.setMontant(transactionrepos.getMontant());
		transactionEvent.setType_transaction(transactionrepos.getType_transaction());

		System.out.println("envoie de la requete de depot vers le service compte " + transactionEvent);
		rabbitTemplate.convertAndSend("transactionExchange", "transaction.created", transactionEvent);
        return transactionrepos;
	}

	public Transaction effectuerRetrait(String telephone, float montant) throws Exception {
		if (telephone == null) {
			throw new IllegalArgumentException("Événement de retrait invalide.");
		}
		Transaction transaction = new Transaction();
		transaction.setTelephone(telephone);
		transaction.setMontant(montant);
		transaction.setType_transaction("WITHDRAWAL");

		Transaction transactionrepos = transactionRepository.save(transaction);

		TransactionEvent transactionEvent = new TransactionEvent();
		
		transactionEvent.setTransaction_id(transactionrepos.getTransaction_id());
		transactionEvent.setTelephone(transactionrepos.getTelephone());
		transactionEvent.setMontant(transactionrepos.getMontant());
		transactionEvent.setType_transaction(transactionrepos.getType_transaction());

		System.out.println("envoie de la requete de retrait vers le service compte " + transactionEvent);
		rabbitTemplate.convertAndSend("transactionExchange", "transaction.created", transactionEvent);
		return transactionrepos;
	}
}
