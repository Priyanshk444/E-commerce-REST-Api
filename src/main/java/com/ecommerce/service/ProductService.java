package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entities.dto.ProductDto;

public interface ProductService {

	ProductDto addProduct(ProductDto productDto);
	
	List<ProductDto> getAllProduct();
	
	ProductDto getProduct(Long productId);
	
	ProductDto updateProduct(Long productId,ProductDto productDto);
	
	void deleteProduct(Long prodId);
}
