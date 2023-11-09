package com.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShoppingCartResponse {
	private Long userId;
	private Long cartId;
	private Integer totalItems;
	private Double totalCosts;
	private List<Product>products;
	

}
