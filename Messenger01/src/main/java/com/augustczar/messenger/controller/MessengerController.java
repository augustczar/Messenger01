package com.augustczar.messenger.controller;

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
	
	@GetMapping("/send")
	public ResponseEntity<String> send(){
	
		queueSender.send("Are you receiving the message from the messenger");
		
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
}
