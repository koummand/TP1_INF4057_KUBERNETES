package com.m1fonda.banque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Userbanque {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String userName;
private String password;
private String cni;
private String email;
private String phoneNumber;
private Boolean compteActif=false;

public Boolean getCompteActif() {
return compteActif;
}
public void setCompteActif(Boolean compteActif) {
this.compteActif = compteActif;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
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
public Userbanque() {
super();
}
public Userbanque(int id, String userName, String password, String cni, String email, String phoneNumber,Boolean compteActif) {
super();
this.id = id;
this.userName = userName;
this.password = password;
this.cni = cni;
this.email = email;
this.phoneNumber = phoneNumber;
this.compteActif=compteActif;
}

}

