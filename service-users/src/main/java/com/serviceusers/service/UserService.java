package com.serviceusers.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceusers.event.UserEvent;
import com.serviceusers.model.Userbanque;
import com.serviceusers.repository.UserRepository;

@Service
public class UserService {

// Qunad tu enregistre publie l evenement
@Autowired
UserRepository userRepo;

// on utlise RabbitTemplate pour publier l evenenment
@Autowired
private RabbitTemplate rabbitTemplate;

// Qunad tu enregistre un utilisateur publie l evenement
public void addUsers(Userbanque user) {

try {
// Enregistrer un user
user.setCompteActif(true);
Userbanque saveUser = userRepo.save(user);
// Publier les evenemt
UserEvent event = new UserEvent();

event.setUserName(saveUser.getUserName());
event.setPassword(saveUser.getPassword());
event.setCni(saveUser.getCni());
event.setEmail(saveUser.getEmail());
event.setPhoneNumber(saveUser.getPhoneNumber());
event.setCompteActif(saveUser.getCompteActif());

// publie le user sur rabbitmq
rabbitTemplate.convertAndSend("userExchange", "user.created", event);

} catch (Exception e) {
throw new RuntimeException("Error lors de l'insertion de l'utilisateur", e);
}
}

// suprimer un utilisateur
public List<Userbanque> deleteUsers(int id) {
userRepo.deleteById(id);
return userRepo.findAll();
}

// recupere les utilisateur
public List<Userbanque> getAllUsers() {
return userRepo.findAll();
}

// recherche d un utilisateur
public Userbanque getUsers(int id) {
return userRepo.findById(id).orElse(null);
}

//recherche d un utilisateur
public Userbanque getUserByphone(String telephone) {
	try {
		return userRepo.findByPhoneNumber(telephone);
	}catch(Exception e) {
		throw new NoSuchElementException("utilisateur introuvable");
	}
}

}