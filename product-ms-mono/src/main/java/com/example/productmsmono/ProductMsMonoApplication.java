package com.example.productmsmono;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com.repo")
@EntityScan("com.entity")
@EnableSwagger2
public class ProductMsMonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsMonoApplication.class, args);
	}

	@Bean
	public Docket swaggerconf() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com"))
						.build()
						.apiInfo(apiDetails());
	}

private ApiInfo apiDetails() {
	return new ApiInfo("Product Api Documentation","Sample Api for end user review",
			"1.3.4",
			"for internal use only",
			new springfox.documentation.service.Contact("Itashi",
					"itashi2tech.com", "connect.com"),
			"API License",
			"http://product.com",
			Collections.emptyList()
			);
	
			
}
}
