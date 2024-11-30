package com.siv.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.siv"})
public class MovieMicroserviceApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(MovieMicroserviceApplication.class, args);
	}

}
