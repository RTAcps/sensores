package com.rtacps.sensores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SensoresApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SensoresApplication.class, args);
	}

}
