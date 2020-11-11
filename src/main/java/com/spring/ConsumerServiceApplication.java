package com.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class ConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}
    
	@RestController
	class Consumer{
		@Value("${message}")
		private String mensaje;

		@Value("$global-message}")
	    private String mensajeGlobal;
	
		@RequestMapping(method = RequestMethod.GET)
		public Map<String,String> mensaje() {
			Map<String,String> response = new HashMap<>();
			response.put("Mensaje", mensaje);
			response.put("Mensaje Global",mensajeGlobal);

			return response;
		}
		
	}
	
}
