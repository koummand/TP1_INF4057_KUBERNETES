package com.m1fonda.banque.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {
	// Creer un convertisseur de message pour gerer la sérialisation et la
	// désérialisation
	@Bean
	public Jackson2JsonMessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	// Configuration de RabbitTemple pour utiliser le convertisseur
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

		rabbitTemplate.setMessageConverter(jsonMessageConverter());

		return rabbitTemplate;
	}

	@Bean
	public TopicExchange banqueExchange() {
		return new TopicExchange("banqueExchange"); // Queue durable pour les notifications de validation
	}

	@Bean
	public Queue banqueQueue() {
		return new Queue("banqueQueue"); // Queue durable pour les notifications de validation
	}

	@Bean
	public Queue demandeQueue() {
		return new Queue("demandeQueue", true, false, false);//creer la queue de la demande si celle ci n existe pas
	}

	@Bean
	public Binding binding(TopicExchange banqueExchange, Queue banqueQueue) {
		return BindingBuilder.bind(banqueQueue).to(banqueExchange).with("banque.created");
	}

}
