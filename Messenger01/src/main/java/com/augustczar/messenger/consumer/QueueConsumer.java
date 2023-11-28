package com.augustczar.messenger.consumer;

import java.time.LocalDateTime;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.augustczar.messenger.exceptionhandling.BusinessException;

@Component
public class QueueConsumer {
	@RabbitListener(queues= "${queue.name}")
	public void receive(@Payload Message message) throws BusinessException {
        System.out.println("Message: " + message + "  " + LocalDateTime.now());
        String ultima = String.valueOf(message.getHeaders().get("ultima"));
        if(ultima.equals("sim")){
            System.out.println(ultima);
        }
        String payload = String.valueOf(message.getPayload());
        if(payload.equals(1)) {
            throw new BusinessException("testando a excecao");
        }
    }
}
