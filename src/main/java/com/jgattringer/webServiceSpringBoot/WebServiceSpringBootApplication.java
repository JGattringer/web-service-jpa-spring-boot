package com.jgattringer.webServiceSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta anotação indica que esta classe é o ponto de entrada principal da aplicação Spring Boot
@SpringBootApplication
public class WebServiceSpringBootApplication {

	public static void main(String[] args) {
		// Inicializa a aplicação Spring Boot, passando a classe principal e quaisquer argumentos de linha de comando
		SpringApplication.run(WebServiceSpringBootApplication.class, args);
	}

}
