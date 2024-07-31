package com.ecommerce.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entities.dto.AddressDto;
import com.ecommerce.service.AddressService;

@RestController
@RequestMapping("/api/user/address")
public class addressController {

	private AddressService addressService;
	
	public addressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@PostMapping("/{userId}")
	public AddressDto addAddress(@PathVariable("userId") Long id,@RequestBody AddressDto addressDto) {
		return addressService.addAdress(id, addressDto);
	}
	
	@PutMapping("/{addressId}")
	public AddressDto updateAddress(@PathVariable("addressId") Long id,@RequestBody AddressDto addressDto) {
		return addressService.updateAddress(id, addressDto);
	}
	
	@DeleteMapping("/{addressId}")
	public void deleteAddress(@PathVariable("addressId") Long id) {
		addressService.removeAddress(id);
	}
}
