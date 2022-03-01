package org.generation.blogpessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Classe inicial do aplicativo Spring Boot
*/

@SpringBootApplication /*anotação que lê, configura automaticamente todos os frameworks e executa o projeto.*/
public class BlogpessoalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogpessoalApplication.class, args);/*Linha principal que roda o projeto.*/
	}

}
