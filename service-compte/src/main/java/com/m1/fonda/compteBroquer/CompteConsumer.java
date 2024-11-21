package com.m1.fonda.compteBroquer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m1.fonda.event.CompteEvent;
import com.m1.fonda.event.TransactionEvent;
import com.m1.fonda.service.CompteService;

import jakarta.transaction.Transactional;

@Service
public class CompteConsumer {

	@Autowired
	private CompteService compteService;
	
	@RabbitListener(queues = "banqueQueue")
	public void creerCompte(CompteEvent event) {

		System.out.println("requete recu pour creation de  compte " + event);

		compteService.creerComptes(event.getClientId(), event.getTelephone(), event.getTypeBanque());

	}

	@RabbitListener(queues = "transactionQueue")
	public void effectuerTransaction(TransactionEvent event) {
		if ("DEPOSIT".equals(event.getType_transaction())) {

			System.out.println("requete recu pour effectuer un depot dans compte " + event);
			compteService.effectuerDepot(event);

		} else if ("WITHDRAWAL".equals(event.getType_transaction())) {

			System.out.println("requete recu pour effectuer un retait dans compte " + event);
			compteService.effectuerRetrait(event);

		} else {
			System.out.println("Type d'opération non reconnu : " + event.getType_transaction());
		}

	}

}
