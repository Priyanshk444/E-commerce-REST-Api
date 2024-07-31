package com.ecommerce.service.impl;

import org.springframework.stereotype.Service;

import com.ecommerce.entities.Address;
import com.ecommerce.entities.LocalUser;
import com.ecommerce.entities.dto.AddressDto;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.AddressRepository;
import com.ecommerce.repository.LocalUserRepoitory;
import com.ecommerce.service.AddressService;
import com.ecommerce.util.Mapper;
@Service
public class AddressServiceImpl implements AddressService {

	private LocalUserRepoitory userRepoitory;
	
	private AddressRepository addressRepository;
	
	public AddressServiceImpl(LocalUserRepoitory userRepoitory,AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
		this.userRepoitory = userRepoitory;
	}
	
	@Override
	public AddressDto addAdress(Long userId, AddressDto addressDto) {
		Address address = Mapper.addressDtoToaddress(addressDto);
		LocalUser user = userRepoitory.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "userRepository", userId));
		address.setUser(user);
		Address address2 = addressRepository.save(address);
		return Mapper.addresstoAddressDto(address2);
	}

	@Override
	public AddressDto updateAddress(Long addressId,AddressDto addressDto) {
		Address address = addressRepository.findById(addressId).orElseThrow(()-> new ResourceNotFoundException("address", "address repository", addressId));
		address.setAddress1(addressDto.getAddress1());
		address.setAddress2(addressDto.getAddress2());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		return Mapper.addresstoAddressDto(addressRepository.save(address));
	}

	@Override
	public void removeAddress(Long addressId) {
		
		addressRepository.deleteById(addressId);
	}

}
