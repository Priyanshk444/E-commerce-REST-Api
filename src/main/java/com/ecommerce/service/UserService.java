package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entities.dto.LocalUserDto;

public interface UserService {

	LocalUserDto createUser(LocalUserDto userDto);
	
	LocalUserDto updateUser(LocalUserDto userDto,Long id);
	
	List<LocalUserDto> getAllUsers();	
	
	LocalUserDto getUserById(Long id);
	
	void deleteUser(Long id);
}
