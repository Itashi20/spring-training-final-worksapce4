package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.entity.CartEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Product;
import com.model.ShoppingCartRequest;
import com.model.ShoppingCartResponse;
import com.repo.ShopRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AppService {

	@Autowired()
	@Qualifier("webclient")
	private WebClient.Builder builder;
	
	@Autowired
	private ShopRepo repo;
	
	@CircuitBreaker(fallbackMethod="fallBackMethod", name = "cb")
	public ShoppingCartResponse processAndSend(Long userId,List<ShoppingCartRequest>shoppingCartrequests)
	{
		ObjectMapper mapper= new ObjectMapper();
		String productServiceURL="http://product-service/shoppingcart/loadProducts/"+ shoppingCartrequests.stream()
		.map(e ->String.valueOf(e.getProductId())).collect(Collectors.joining(","));
		
	
	
	List<Product>productServiceList=builder.build()
			.get()
			.uri(productServiceURL)
			.retrieve()
			.bodyToFlux(Product.class)
			.collectList()
			.block();
	
	
	System.out.println(productServiceURL);
	System.out.println(productServiceList);
	//calculate the  totalcost
	final Double [] totalcosts= {0.0};
	productServiceList.forEach(ps1->{
		shoppingCartrequests.forEach(cr->{
			if(ps1.getProductId()==cr.getProductId()) {
				ps1.setQuantity(cr.getQuantity());
				totalcosts[0]=totalcosts[0]+ps1.getPrice()*cr.getQuantity();		
			}
		});
	});
	
	//create cart entity
	
	CartEntity cartEntity=null;
	try {
		cartEntity=CartEntity.builder().userId(userId)
				.cartId((long)(Math.random()*Math.pow(10,10)))
				.totalItems(productServiceList.size())
				.totalCosts(totalcosts[0])
				.products(mapper.writeValueAsString(productServiceList))
                 .build();
		cartEntity=repo.save(cartEntity);
	}
	catch(Exception e) {
		
	}
	//return response
	ShoppingCartResponse re=ShoppingCartResponse.builder()
      .cartId(cartEntity.getCartId())
      .userId(cartEntity.getUserId())
      .totalCosts(cartEntity.getTotalCosts())
      .products(productServiceList)
      .build();
			
			
			return re;
	}
	
	
	
	public ShoppingCartResponse fallBackMethod(Throwable t) {
		System.out.println("Hey!Server is down");
		//return "not working";
		//return new ShoppingCartResponse("not working",HttpStatus.BAD_REQUEST);
		return null;
	}
	
}
