package com.ecommerce.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entities.dto.InventoryDto;
import com.ecommerce.entities.dto.ProductDto;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private ProductService productService;
	
	private InventoryService inventoryService;
	
	public ProductController(InventoryService inventoryService, ProductService productService) {
		this.inventoryService = inventoryService;
		this.productService = productService;
	}
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> getProducts(@PathVariable("productId") Long id) {
		return new ResponseEntity<ProductDto>( productService.getProduct(id), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<ProductDto>> getAllProduct(){
		return new ResponseEntity<List<ProductDto>>(productService.getAllProduct(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
		ProductDto product = productService.addProduct(productDto);
		return new ResponseEntity<ProductDto>(product,HttpStatus.OK);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable("productId") Long id){
		ProductDto updateProduct = productService.updateProduct(id, productDto);
		return new ResponseEntity<ProductDto>(updateProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("productId") Long Id){
		productService.deleteProduct(Id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PostMapping("/{productId}/inventory")
	public ResponseEntity<ProductDto> createInventory(@PathVariable("productId") Long id,@RequestBody InventoryDto inventoryDto){
		ProductDto productDto = inventoryService.createInventory(inventoryDto, id);
		return new ResponseEntity<ProductDto>(productDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/{productId}/inventory")
	public ResponseEntity<ProductDto> updateInventory(@PathVariable("productId") Long id,@RequestBody InventoryDto inventoryDto){
		ProductDto productDto = inventoryService.updateInventory(inventoryDto, id);
		return new ResponseEntity<ProductDto>(productDto,HttpStatus.CREATED);
	}
	
}
