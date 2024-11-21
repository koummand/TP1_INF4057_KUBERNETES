package com.m1.fonda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transaction_id;
	private String telephone;
	private float montant;
	private String Type_transaction;

	public Transaction() {
		super();
	}
	public Transaction(int transaction_id, String telephone, float montant, String type_transaction) {
		super();
		this.transaction_id = transaction_id;
		this.telephone = telephone;
		this.montant = montant;
		this.Type_transaction = type_transaction;
	}

	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getType_transaction() {
		return Type_transaction;
	}
	public void setType_transaction(String type_transaction) {
		Type_transaction = type_transaction;
	}
}
