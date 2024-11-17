package com.m1.fonda.config;

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
public TopicExchange compteExchange() {
return new TopicExchange("compteExchange");
}

@Bean
public Queue compteQueue() {
return new Queue("compteQueue"); // Queue durable pour les demandes à valider
}

@Bean
public Queue banqueQueue() {
return new Queue("banqueQueue", true, false, false); // on creer la queue de la banque si elle n existe pas
}
@Bean
public Queue transactionretraitQueue() {
return new Queue("transactionQueue", true, false, false); // on creer la queue de la banque si elle n existe pas
}

@Bean
public Binding binding(TopicExchange compteExchange, Queue compteQueue) {
return BindingBuilder.bind(compteQueue).to(compteExchange).with("compte.created");
}

}
