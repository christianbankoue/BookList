package com.cbankoue.booklist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbankoue.booklist.Exception.ResourceNotFoundException;
import com.cbankoue.booklist.entity.User;
import com.cbankoue.booklist.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		
		List<User> users = userRepository.findAll(); 
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user found with id " + id));
		
		return ResponseEntity.ok(user);
		
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		return ResponseEntity.ok(userRepository.save(user));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
		
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user found with id " + id));
		
		user.setEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setMobile(userDetails.getMobile());
		user.setPassword(userDetails.getPassword());
		user.setRole(user.getRole());
		
		return ResponseEntity.ok(userRepository.save(user));
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user found with id " + id));
		
		Map<String, Boolean> response = new HashMap<>();
		
		userRepository.delete(user);
		
		response.put("delete", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
	

}
