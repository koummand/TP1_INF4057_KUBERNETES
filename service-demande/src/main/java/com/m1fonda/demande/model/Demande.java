package com.m1fonda.demande.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Demande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int clientId;
	private String nom;
	private String cni;
	private String phoneNumber;
	private String password;
	private String dateDemande;
	private String typeBanque;
	private String action ="CREATION_COMPTE";
	

	public Demande() {
		super();
	}



	
   public Demande(int id, int clientId, String nom, String cni, String phoneNumber, String password,
			String dateDemande, String typeBanque, String action) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.nom = nom;
		this.cni = cni;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.dateDemande = dateDemande;
		this.typeBanque = typeBanque;
		this.action = action;
	}



	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	public String getAction() {
		return action;
	}
	
	
	
	
	public void setAction(String action) {
		this.action = action;
	}
}
