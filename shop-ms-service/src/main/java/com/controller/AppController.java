package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.ShoppingCartRequest;
import com.model.ShoppingCartResponse;
import com.service.AppService;

@RestController
@RequestMapping("/shoppingcart")
@RefreshScope
public class AppController {
	@Value("${shop.appname}")
	private String message;
	
	@Autowired
	private AppService service;
	
	@PostMapping("/{userid}/products")
	public ResponseEntity addProduct(@PathVariable Long userid, @RequestBody List<ShoppingCartRequest> reqProdList) {
		ShoppingCartResponse response = service.processAndSend(userid, reqProdList);
		System.out.println(message);
		return new ResponseEntity(response, HttpStatus.CREATED);
	}
}
