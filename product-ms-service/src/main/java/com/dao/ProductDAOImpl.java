package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repo.ProductREPO;

@Service
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	ProductREPO repo;
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product);
		//return product;
	}

	@Override
	public List<Product> loadProducts() {
		// TODO Auto-generated method stub
		
		return (List<Product>)repo.findAll();
	}

	@Override
	public List<Product> getByIds(List<Long> plist) {
		// TODO Auto-generated method stub
		return (List<Product>)repo.findAllById(plist);
	}

}
