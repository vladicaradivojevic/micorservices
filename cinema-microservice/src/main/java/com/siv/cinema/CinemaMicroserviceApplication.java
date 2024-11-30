package com.siv.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.siv"})
public class CinemaMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaMicroserviceApplication.class, args);
	}

}
