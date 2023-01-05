package com.grocery.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.dto.UserDTO;
import com.grocery.entity.User;
import com.grocery.exception.InvalidCredentialsException;
import com.grocery.exception.UserExistsException;
import com.grocery.service.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@Validated
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO userdto) throws UserExistsException {
			userService.registerUser(userdto);
			return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Integer> loginUser(@RequestBody UserDTO userdto) throws InvalidCredentialsException {
			User user = userService.loginUser(userdto);
			return new ResponseEntity<>(user.getUserId(), HttpStatus.OK);
			
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id){
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		userService.deleteById(id);
		return new ResponseEntity<String>("user Deleted", HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
		User user2 = userService.UpdateUser(id, user);
		return new ResponseEntity<User>(user2, HttpStatus.OK);
	}
	

}