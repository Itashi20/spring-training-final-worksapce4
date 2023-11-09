package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ApiModel(description="Details about the product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	@Id
	@GeneratedValue	
private Long productId;
private String productName;
private int quantity;
private Double price;

}
