package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//@ApiModel(description="Details about the product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CartEntity {
	@Id
private Long userId;
private Long cartId;
private Integer totalItems;
private Double totalCosts;
private String products;

}
