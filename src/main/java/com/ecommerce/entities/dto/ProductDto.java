package com.ecommerce.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

	private String name;
	
	private String shortDesc;
	
	private String longDesc;
	
	private double price;
	
	private InventoryDto inventoryDto;
}
