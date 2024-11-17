package com.m1fonda.demande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceDemandeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDemandeApplication.class, args);
	}

}