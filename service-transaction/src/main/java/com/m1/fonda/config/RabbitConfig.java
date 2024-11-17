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
public TopicExchange transactionExchange() {
return new TopicExchange("transactionExchange");
}

@Bean
public Queue transactionQueue() {
return new Queue("transactionQueue"); // Queue durable pour les demandes à valider
}

@Bean
public Binding binding(TopicExchange transactionExchange, Queue transactionQueue) {
return BindingBuilder.bind(transactionQueue).to(transactionExchange).with("transaction.created");
}

}
