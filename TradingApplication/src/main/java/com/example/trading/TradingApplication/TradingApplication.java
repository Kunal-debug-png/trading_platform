package com.example.trading.TradingApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TradingApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TradingApplication.class);
		app.setAdditionalProfiles("debug");
		app.run(args);
	}

}
