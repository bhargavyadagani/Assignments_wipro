package com.example.ecommerce_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceAppApplication {

	public static void main(String[] args) {
		System.out.println(">>> Starting Spring Boot App <<<");
		SpringApplication.run(EcommerceAppApplication.class, args);
	}

}
