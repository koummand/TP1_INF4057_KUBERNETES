package com.m1fonda.banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBanqueApplication.class, args);
	}

}
