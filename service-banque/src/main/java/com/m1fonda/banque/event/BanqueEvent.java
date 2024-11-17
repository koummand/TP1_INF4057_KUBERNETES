package com.m1fonda.banque.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class BanqueEvent {

@JsonProperty("clientId")
private int clientId;
@JsonProperty("numBanque")
private String numBanque;
@JsonProperty("typeBanque")
private String typeBanque;

public BanqueEvent() {
super();
}

public BanqueEvent(int clientId, String numBanque, String typeBanque) {
super();
this.clientId=clientId;
this.numBanque = numBanque;
this.typeBanque = typeBanque;
}

public String getNumBanque() {
return numBanque;
}

public void setNumBanque(String numBanque) {
this.numBanque = numBanque;
}
public int getClientId(){
return clientId;
}

public void setClientId(int clientId){
this.clientId=clientId;
}
public void setTypeBanque(String typeBanque){
this.typeBanque=typeBanque;
}
public String getTypeBanque() {
return typeBanque;
}

}

