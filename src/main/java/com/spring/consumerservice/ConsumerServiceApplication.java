package com.spring.consumerservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class ConsumerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }
}

@RestController
class Consumer {
    @Value("$ {message}")
    private String message;

    @Value("$ {global-message}")
    private String globalMessage;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> message() {
        Map<String, String> response = new HashMap<>();
        response.put("Mensaje", message);
        response.put("Mensaje Global", globalMessage);

        return response;
    }
}
