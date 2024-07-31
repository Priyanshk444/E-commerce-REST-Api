package com.ecommerce.service;

import com.ecommerce.entities.dto.InventoryDto;
import com.ecommerce.entities.dto.ProductDto;

public interface InventoryService {

	ProductDto createInventory(InventoryDto inventoryDto,Long userId);
	
	ProductDto updateInventory(InventoryDto inventoryDto,Long UserId);
	
}
