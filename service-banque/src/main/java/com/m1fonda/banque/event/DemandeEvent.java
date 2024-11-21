package com.m1fonda.banque.event;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import lombok.ToString;

@ToString
public class DemandeEvent {

	@JsonProperty("clientId")
	private int clientId;
	@JsonProperty("nom")
	private String nom;
	@JsonProperty("cni")
	private String cni;
	@JsonProperty("phoneNumber")
	@Column(length = 20, nullable = false, unique = true)
	private String phoneNumber;
	@JsonProperty("password")
	private String password;
	@JsonProperty("dateDemande")
	private String dateDemande;
	@JsonProperty("typeBanque")
	private String typeBanque;

	public DemandeEvent(int clientId, String nom, String cni, String phoneNumber, String password,
			String dateDemande, String typeBanque) {
		super();
		this.clientId = clientId;
		this.nom = nom;
		this.cni = cni;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.dateDemande = dateDemande;
		this.typeBanque=typeBanque;
	}

	public DemandeEvent() {
		super();
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCni() {
		return cni;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}
	public String getTypeBanque() {
		return typeBanque;
	}

	public void setTypeBanque(String typeBanque) {
		this.typeBanque = typeBanque;
	}
}
