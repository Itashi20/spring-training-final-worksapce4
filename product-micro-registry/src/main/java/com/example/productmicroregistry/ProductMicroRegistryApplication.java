package com.example.productmicroregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ProductMicroRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroRegistryApplication.class, args);
	}

}
