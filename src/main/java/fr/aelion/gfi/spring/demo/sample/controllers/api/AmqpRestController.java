package fr.aelion.gfi.spring.demo.sample.controllers.api;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/amqp")
@Log
public class AmqpRestController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AmqpRestController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("send")
    public void sendAMQPMessage() {
        rabbitTemplate.convertAndSend("spring-boot", "Hello, world!");
    }

    @RabbitListener(queues = "spring-boot")
    public void listen(String in) {
        log.info("Message read from myQueue : " + in);
    }
}
