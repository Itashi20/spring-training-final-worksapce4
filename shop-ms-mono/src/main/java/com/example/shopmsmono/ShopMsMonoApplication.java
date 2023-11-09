package com.example.shopmsmono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.repo")
@EntityScan("com.entity")
@EnableSwagger2
public class ShopMsMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopMsMonoApplication.class, args);
	}
	
	@Bean("webclient")
public WebClient.Builder getWebClient(){
	return WebClient.builder();
}
}
