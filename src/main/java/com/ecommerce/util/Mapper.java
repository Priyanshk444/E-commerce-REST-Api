package com.ecommerce.util;

import java.util.stream.Collectors;

import com.ecommerce.entities.Address;
import com.ecommerce.entities.Inventory;
import com.ecommerce.entities.LocalUser;
import com.ecommerce.entities.Product;
import com.ecommerce.entities.dto.AddressDto;
import com.ecommerce.entities.dto.InventoryDto;
import com.ecommerce.entities.dto.LocalUserDto;
import com.ecommerce.entities.dto.ProductDto;

public class Mapper {

	public static LocalUser userDtoToUser(LocalUserDto userDto) {
		LocalUser localUser = new LocalUser();
		localUser.setFirstName(userDto.getFirstName());
		localUser.setLastName(userDto.getLastName());
		localUser.setUsername(userDto.getUsername());
		localUser.setPassword(userDto.getPassword());
		localUser.setEmail(userDto.getEmail());
		return localUser;
	}
	
	public static LocalUserDto userToUserDto(LocalUser user) {
		LocalUserDto userDto = new LocalUserDto();
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setAllAddressDtos(user.getAllAddress().stream().map((address)->Mapper.addresstoAddressDto(address)).collect(Collectors.toList()));
		return userDto;
	}
	
	public static Address addressDtoToaddress(AddressDto addressDto) {
		Address address = new Address();
		address.setAddress1(addressDto.getAddress1());
		address.setAddress2(addressDto.getAddress2());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		return address;
	}
	
	public static AddressDto addresstoAddressDto(Address address) {
		AddressDto addressDto = new AddressDto(address.getAddress1(), address.getAddress2(), address.getCity(), address.getCountry());
		return addressDto;
	}
	
//	
//	public static Product productDtoToProduct(ProductDto productDto) {
//		Product product = new Product();
//		product.setInventory( productDto.getInventory().getQuantity());
//		product.setLongDesc(productDto.getLongDesc());
//		product.setName(productDto.getName());
//		product.setPrice(productDto.getPrice());
//		product.setShortDesc(product.getShortDesc());
//		return product;
//	}
	
	public static ProductDto prodToProdDto(Product product) {
		InventoryDto inventoryDto = new InventoryDto();
		if(product.getInventory() != null) {
			inventoryDto.setQuantity(product.getInventory().getQuantity());
		} else {
			inventoryDto.setQuantity(0);
		}
			ProductDto productDto = new ProductDto(product.getName(),product.getShortDesc(), product.getLongDesc(), product.getPrice(), inventoryDto);
		
			return productDto;
	}
	
//	public static InventoryDto inventoryToInventoryDto(Inventory inventory) {
//		Inventory
//	}
}
