package com.augustczar.messenger.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Bean
	Queue messengerQueue() {
		return new Queue("messenger01", true);
	}
	
	@Bean
	DirectExchange exachange() {
		return new DirectExchange("direct-exchange");
	}
	
	@Bean
	Binding messengerBinding(Queue messengerQueue, DirectExchange exchange) {
		return BindingBuilder.bind(messengerQueue).to(exchange).with("messenger-routing-key");
	}
}
