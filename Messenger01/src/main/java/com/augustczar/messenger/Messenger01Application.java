package com.augustczar.messenger;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Messenger01Application {

	public static void main(String[] args) {
		SpringApplication.run(Messenger01Application.class, args);
	}

}
