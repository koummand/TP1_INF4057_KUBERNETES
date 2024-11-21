package com.m1.fonda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Compte {
	@Id
	private String account_id;
	private int clientId;
	@Column(length = 20, nullable = false, unique = true)
	private String telephone;
	private String typeBanque;
	private float solde;

	public Compte() {
		super();
	}

	public Compte(String account_id, int clientId,String telephone, String typeBanque, float solde) {
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
