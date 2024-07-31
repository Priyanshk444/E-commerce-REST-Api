package com.ecommerce.service.impl;

import org.springframework.stereotype.Service;

import com.ecommerce.entities.Inventory;
import com.ecommerce.entities.Product;
import com.ecommerce.entities.dto.InventoryDto;
import com.ecommerce.entities.dto.ProductDto;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.inventoryRepository;
import com.ecommerce.repository.productRepository;
import com.ecommerce.service.InventoryService;
import com.ecommerce.util.Mapper;
@Service



public class InventoryServiceImpl implements InventoryService {

	
	private productRepository productRepository;
	
	private inventoryRepository inventoryRepository;
	
	
	public InventoryServiceImpl( productRepository productRepository,inventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
		this.productRepository = productRepository;
	}
	
	@Override
	public ProductDto createInventory(InventoryDto inventoryDto, Long userId) {
		Product product = productRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("product", "Product Repository", userId) );
		Inventory inventory = new Inventory();
		inventory.setProduct(product);
		inventory.setQuantity(inventoryDto.getQuantity());
		product.setInventory(inventory);
		inventoryRepository.save(inventory);
		return Mapper.prodToProdDto(productRepository.save(product));
	}

	@Override
	public ProductDto updateInventory(InventoryDto inventoryDto, Long UserId) {
		Product product = productRepository.findById(UserId).orElseThrow(()-> new ResourceNotFoundException("product", "Product Repository", UserId) );
		Inventory inventory = product.getInventory();
		inventory.setQuantity(inventoryDto.getQuantity());
		product.setInventory(inventory);
		inventoryRepository.save(inventory);
		return Mapper.prodToProdDto(productRepository.save(product));
	}

}
