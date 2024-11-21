package com.m1.fonda.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import lombok.ToString;

@ToString
public class TransactionEvent {

	@JsonProperty("transaction_id")
	private int transaction_id;
	@JsonProperty("telephone")
	private String telephone;
	@JsonProperty("montant")
	private float montant;
	@JsonProperty("Type_transaction")
	private String Type_transaction;

	public TransactionEvent() {
		super();
	}

	public TransactionEvent(int transaction_id, String telephone, float montant, String type_transaction) {
		super();
		this.transaction_id = transaction_id;
		this.telephone = telephone;
		this.montant = montant;
		Type_transaction = type_transaction;
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
