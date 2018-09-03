package com.pseh.footballeague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@SpringBootApplication
public class FootballeagueApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(FootballeagueApplication.class, args);
	}
	
	
}

