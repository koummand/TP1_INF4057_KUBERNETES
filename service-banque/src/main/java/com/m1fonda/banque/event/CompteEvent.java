package com.m1fonda.banque.event;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.ToString;

@ToString
public class CompteEvent {
	@Id
	@JsonProperty("account_id")
	private String account_id;
	@JsonProperty("clientId")
	private int clientId;
	@JsonProperty("telephone")
	@Column(length = 20, nullable = false, unique = true)
	private String telephone;
	@JsonProperty("typeBanque")
	private String typeBanque;
	@JsonProperty("solde")
	private float solde;

	public CompteEvent() {
		super();
	}

	public CompteEvent(String account_id, int clientId, String telephone, String typeBanque, float solde) {
		super();
		this.account_id = account_id;
		this.clientId = clientId;
		this.telephone=telephone;
		this.typeBanque = typeBanque;
		this.solde = solde;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getTypeBanque() {
		return typeBanque;
	}

	public void setTypeBanque(String typeBanque) {
		this.typeBanque = typeBanque;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public void miseAjourSolde(float montant) {
		this.solde = this.solde + montant;
	}

}
