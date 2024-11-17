package com.m1.fonda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private int clientId;
	private String account_id;
	private String message;
	private String date;
//encoure rejeter accepter
	private String status;
	
public Notification() {
		super();
	}
public Notification(int id,int clientId, String account_id, String message, String date, String status) {
	super();
	this.id = id;
	this.clientId=clientId;
	this.account_id=account_id;
	this.message = message;
	this.date = date;
	this.status = status;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public int getClientId() {
	return clientId;
}

public void setClientId(int clientId) {
	this.clientId = clientId;
}

public String getAccount_id() {
	return account_id;
}

public void setAccount_id(String account_id) {
	this.account_id = account_id;
}
}
