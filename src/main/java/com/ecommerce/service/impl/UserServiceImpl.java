package com.ecommerce.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ecommerce.entities.LocalUser;
import com.ecommerce.entities.dto.LocalUserDto;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.LocalUserRepoitory;
import com.ecommerce.service.UserService;
import com.ecommerce.util.Mapper;
@Service
public class UserServiceImpl implements UserService {
	
	private LocalUserRepoitory userRepoitory;
	
	public UserServiceImpl(LocalUserRepoitory userRepoitory) {
		this.userRepoitory=userRepoitory;
	}

	@Override
	public LocalUserDto createUser(LocalUserDto userDto) {
		
		LocalUser user = Mapper.userDtoToUser(userDto);
		return Mapper.userToUserDto(userRepoitory.save(user));
	}

	@Override
	public LocalUserDto updateUser(LocalUserDto userDto, Long id) {
		LocalUser user = userRepoitory.findById(id).orElseThrow(()->new ResourceNotFoundException("user","user Repository",id));
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		userRepoitory.save(user);
		return Mapper.userToUserDto(user);
	}

	@Override
	public List<LocalUserDto> getAllUsers() {
		List<LocalUserDto> userDtos= userRepoitory.findAll().stream().map((user)->Mapper.userToUserDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public LocalUserDto getUserById(Long id) {
		return Mapper.userToUserDto(userRepoitory.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "user Repository", id)));
	}

	@Override
	public void deleteUser(Long id) {
		userRepoitory.deleteById(id);
	}

}
