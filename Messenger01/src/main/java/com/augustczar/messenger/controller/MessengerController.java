package com.augustczar.messenger.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augustczar.messenger.producer.QueueSender;


@RestController
@RequestMapping("/messenger")
public class MessengerController {

	@Autowired
	private QueueSender queueSender;
	
	private final AmqpTemplate amqpQueueSender;
	
	@GetMapping("/send")
	public String send(){
			queueSender.send("Are you receiving the message from the messenger");
		
		return "Feito!";	
	}
	
	public MessengerController(AmqpTemplate amqpQueueSender) {
		this.amqpQueueSender = amqpQueueSender;
	}
	
	@GetMapping("/brokerSender")
	public String brokerSend(){
		String mensagem = "messenger test messenger";
		
		MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("ultima", "sim");
        Message message = new Message(mensagem.getBytes(), messageProperties);
		
		amqpQueueSender.convertAndSend("messenger-exchange", "routing-key-messenger", message);
		
		return "Terminado!";
	}
	
}
