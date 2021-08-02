package com.alberto.spring.eureka.retrieve.current.transaction.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RetrieveCurrentTransactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(RetrieveCurrentTransactionApplication.class, args);
	}

}
