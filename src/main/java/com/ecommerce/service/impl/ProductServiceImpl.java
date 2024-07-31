package com.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.entities.Inventory;
import com.ecommerce.entities.Product;
import com.ecommerce.entities.dto.ProductDto;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.productRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.util.Mapper;
@Service
public class ProductServiceImpl implements ProductService {

	private productRepository productRepository;
	
	
	public ProductServiceImpl(productRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product2 = new Product();
		product2.setShortDesc(productDto.getShortDesc());
		product2.setLongDesc(productDto.getLongDesc());
		product2.setName(productDto.getName());
		product2.setPrice(productDto.getPrice());
		System.out.println(product2.getShortDesc());
		Product product = productRepository.save(product2);
		return Mapper.prodToProdDto(product);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> all = productRepository.findAll();
		return all.stream().map((prod)->Mapper.prodToProdDto(prod)).collect(Collectors.toList());
	}

	@Override
	public ProductDto updateProduct(Long productId, ProductDto productDto) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product", "product Repository", productId));
		product.setName(productDto.getName());
		product.setShortDesc(productDto.getShortDesc());
		product.setLongDesc(productDto.getLongDesc());
		product.setPrice(productDto.getPrice());
		
		
		Inventory inventory = new Inventory();
		inventory.setQuantity(productDto.getInventoryDto().getQuantity());
		inventory.setProduct(product);
		
		
		product.setInventory(inventory);
		return Mapper.prodToProdDto(productRepository.save(product));
	}

	@Override
	public void deleteProduct(Long prodId) {
		productRepository.deleteById(prodId);
	}


	@Override
	public ProductDto getProduct(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product", "product repository", productId));
		return Mapper.prodToProdDto(product);
	}

}
