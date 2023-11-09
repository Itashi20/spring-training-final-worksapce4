package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ProductDAO;
import com.entity.Product;

@RestController
@RequestMapping("/shoppingcart")
@RefreshScope
public class AppController {
	@Value("${product.appname}")
	private String message;
@Autowired
ProductDAO productdao;

@PostMapping("/addproduct")
public Product addProduct(@RequestBody Product product){
	
	return productdao.addProduct(product);
	//return "Product added successfully in the cart";
	
}

@GetMapping("/loadProducts")
public List<Product> showProducts(){
	return productdao.loadProducts();
}


@GetMapping("/loadProducts/{plist}")
public List<Product> loadProductsByIds(@PathVariable List<Long> plist){
	System.out.println(message);
	return productdao.getByIds(plist);
}


}
