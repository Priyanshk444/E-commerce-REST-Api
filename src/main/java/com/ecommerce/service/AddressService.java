package com.ecommerce.service;

import com.ecommerce.entities.dto.AddressDto;

public interface AddressService {

	AddressDto addAdress(Long userId,AddressDto addressDto);
	
	AddressDto updateAddress(Long addressId,AddressDto addressDto);
	
	void removeAddress(Long addressId);
}
