package com.serviceusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//pour empecher eureka de se fermer automatiquement en faite sa dit a eureka je suis un service d'enregistrement 
@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistrieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistrieApplication.class, args);
	}

}
