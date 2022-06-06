package com.exrate.exrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExrateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExrateApplication.class, args);
	}

}
