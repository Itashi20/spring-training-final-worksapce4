package com.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Product;
@Repository
public interface ProductREPO  extends CrudRepository<Product, Long>{

}
