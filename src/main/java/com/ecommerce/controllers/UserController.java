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

import com.ecommerce.entities.dto.LocalUserDto;
import com.ecommerce.service.UserService;



@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("")
	public ResponseEntity<LocalUserDto> createUser(@RequestBody LocalUserDto userDto) {
		
		
		return new ResponseEntity<LocalUserDto>(userService.createUser(userDto),HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<LocalUserDto>> getAllUser() {
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LocalUserDto> getAllUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LocalUserDto> getUserById(@RequestBody LocalUserDto userDto,@PathVariable("id") Long id){
		return new ResponseEntity<LocalUserDto>(userService.updateUser(userDto, id),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
}
