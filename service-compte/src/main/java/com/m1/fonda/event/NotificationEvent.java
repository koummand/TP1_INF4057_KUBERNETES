package com.m1.fonda.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class NotificationEvent {

	@JsonProperty("clientId")
	private int clientId;
	@JsonProperty("account_id")
	private String account_id;
	@JsonProperty("message")
	private String message;
	@JsonProperty("date")
	private String date;
	@JsonProperty("status")
	private String status;

	public NotificationEvent() {
		super();
	}

	public NotificationEvent(int clientId, String account_id, String message, String date, String status) {
		super();
		this.clientId = clientId;
		this.account_id = account_id;
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

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
}
