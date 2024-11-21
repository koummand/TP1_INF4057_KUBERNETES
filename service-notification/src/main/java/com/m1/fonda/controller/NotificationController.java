package com.m1.fonda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1.fonda.model.Notification;
import com.m1.fonda.service.NotificationService;
@RequestMapping("/api/notification")
@RestController
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	
	
	@GetMapping("/getnotification")
	public List<Notification> getAllNotificationController(){
		return notificationService.getAllNotification();
	}
	

	@GetMapping("/getnotificationbyclientid/{clientId}")
	public List<Notification> getAllNotificationByclientId(@PathVariable int clientId){
		return notificationService.getAllNotificationByclient(clientId);
	}
	

   

}
