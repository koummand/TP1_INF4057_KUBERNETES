package com.m1fonda.demande.event;


import com.fasterxml.jackson.annotation.JsonProperty;

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
private String phoneNumber;
@JsonProperty("password")
private String password;
@JsonProperty("dateDemande")
private String dateDemande;
@JsonProperty("typeBanque")
private String typeBanque;
@JsonProperty("action")
private String action ="CREATION_COMPTE";

public DemandeEvent() {
super();
}

public DemandeEvent(int clientId, String nom, String cni, String phoneNumber, String password,
String dateDemande,String typeBanque,String action) {
super();
this.clientId = clientId;
this.nom = nom;
this.cni = cni;
this.phoneNumber = phoneNumber;
this.password = password;
this.dateDemande = dateDemande;
this.typeBanque=typeBanque;
this.action=action;
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
