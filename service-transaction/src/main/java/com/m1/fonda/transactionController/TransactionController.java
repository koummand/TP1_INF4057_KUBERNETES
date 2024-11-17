package com.m1.fonda.transactionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1.fonda.model.Transaction;
import com.m1.fonda.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

//	public String effectuerDepot(@PathVariable String accountId, @PathVariable BigDecimal montant) {
	@PostMapping("/depot")
	public Transaction effectuerDepot(@RequestBody Transaction transaction) throws Exception {
		String accountId = transaction.getAccount_id();
		float montant = transaction.getMontant();
	
		Transaction transactionsave = transactionService.effectuerDepot(accountId, montant);
		return transactionsave;
//		return "Dépôt effectué avec succès";
	}

//	public String effectuerRetrait(@PathVariable String accountId, @PathVariable BigDecimal montant) {
	@PostMapping("/retrait")
	public Transaction effectuerRetrait(@RequestBody Transaction transaction) throws Exception {

		try {
			String accountId = transaction.getAccount_id();
			float montant = transaction.getMontant();
			Transaction transactionsave = transactionService.effectuerRetrait(accountId, montant);
			return transactionsave;
//			return "Retrait effectué avec succès";
		} catch (Exception e) {
			throw new IllegalArgumentException("Erreur: "+e.getMessage());
		}
	}
}
