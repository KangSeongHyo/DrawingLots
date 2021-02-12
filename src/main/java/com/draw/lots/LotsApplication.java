package com.draw.lots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotsApplication.class, args);
	}

}
