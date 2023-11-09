package com.dao;

import java.util.List;

import com.entity.Product;



public interface ProductDAO {

	public Product addProduct(Product product);
	public List<Product>loadProducts();
	public List<Product>getByIds(List<Long>plist);
	
}
