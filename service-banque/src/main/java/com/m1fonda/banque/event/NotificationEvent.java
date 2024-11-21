package com.m1fonda.banque.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class NotificationEvent {

	@JsonProperty("clientId")
	private int clientId;
	@JsonProperty("telephone")
	private String telephone;
	@JsonProperty("message")
	private String message;
	@JsonProperty("date")
	private String date;
	@JsonProperty("status")
	private String status;

	public NotificationEvent() {
		super();
	}

	public NotificationEvent(int clientId, String telephone, String message, String date, String status) {
		super();
		this.clientId = clientId;
		this.telephone= telephone;
		this.message = message;
		this.date = date;
		this.status = status;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
