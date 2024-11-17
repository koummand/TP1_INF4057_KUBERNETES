package com.serviceusers.config;

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

//import org.springframework.amqp.core.Queue;

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

	// fonction pour creer la liste d'attente topic
	@Bean
	public TopicExchange userExchange() {
		return new TopicExchange("userExchange");
	}

	// fonction pour creer la liste d'attente queue
	@Bean
	public Queue userQueue() {
		return new Queue("userQueue");
	}

	@Bean
	public Queue notificationQueue() {
		return new Queue("notificationQueue", true, false, false);// Queue durable pour les notifications de validation
	}

	// userExchange utilise userQueue pour souscrire fonction d'association des deux
	// fonctions de creation de liste ci dessus via une clé
	@Bean
	public Binding binding(TopicExchange userExchange, Queue userQueue) {
		return BindingBuilder.bind(userQueue).to(userExchange).with("user.created");
	}

}
