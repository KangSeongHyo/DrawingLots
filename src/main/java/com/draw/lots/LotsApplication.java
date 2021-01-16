package com.draw.lots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotsApplication.class, args);
	}

}
