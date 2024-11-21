package com.m1fonda.banque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Banque {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int banqueId;
private int clientId;
private String numBanque;
private String typeBanque; // "VALIDÉ" ou "REFUSÉ"

public Banque() {
super();
}

public Banque(int banqueId,int clientId, String numBanque, String typeBanque) {
super();
this.banqueId = banqueId;
this.clientId=clientId;
this.numBanque = numBanque;
this.typeBanque = typeBanque;
}

public int getBanqueId() {
return banqueId;
}
public void setBanqueId(int banqueId) {
this.banqueId = banqueId;
}
public int getClientId(){
return clientId;
}
public void setClientId(int clientId){
this.clientId=clientId;
}

public String getNumBanque() {
return numBanque;
}

public void setNumBanque(String numBanque) {
this.numBanque = numBanque;
}

public String getTypeBanque() {
return typeBanque;
}

public void setTypeBanque(String typeBanque) {
if (typeBanque != null && 
(typeBanque.equalsIgnoreCase("UBA") ||
typeBanque.equalsIgnoreCase("EXPRESS_UNION") ||
typeBanque.equalsIgnoreCase("CCA"))) {

this.typeBanque = typeBanque;
} else {
System.out.println("Veuillez choisir parmi les opérateurs suivants : UBA, EXPRESS_UNION, CCA");
}
}




}
