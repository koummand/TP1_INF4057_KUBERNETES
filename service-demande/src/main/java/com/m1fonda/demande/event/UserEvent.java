package com.m1fonda.demande.event;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import lombok.ToString;


@ToString
public class UserEvent {

//		ici on covertie le json en chaine de caracter ou evenement
@JsonProperty("userName")
private String userName;
@JsonProperty("password")
private String password;
@JsonProperty("cni")
private String cni;
@JsonProperty("email")
private String email;
@JsonProperty("phoneNumber")
@Column(length = 20, nullable = false, unique = true)
private String phoneNumber;
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public String getCni() {
return cni;
}
public void setCni(String cni) {
this.cni = cni;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getPhoneNumber() {
return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}




}
