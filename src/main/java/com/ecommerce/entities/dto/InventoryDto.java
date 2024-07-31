package com.ecommerce.entities.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InventoryDto {

	private int quantity;
	
	public InventoryDto() {
        // Default constructor needed for Jackson deserialization
    }

	@JsonCreator
    public InventoryDto(@JsonProperty("quantity") int quantity) {
        this.quantity = quantity;
    }
}
