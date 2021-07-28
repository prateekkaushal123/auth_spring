package com.project.user.service.controller;

import java.util.List;

import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.service.entity.User;
import com.project.user.service.entity.UserRequest;
import com.project.user.service.services.UserService;
import com.project.user.util.JwtUtil;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class UserController {
	@Autowired
	UserService service;
	
	//@Autowired
	//JwtUtil jwt;
	
	@GetMapping("/health")
	public String respond() {
		MDC.put("user.name", "null");
		log.info("User Service /health called.");
		return "Hello from user service. Service is up"; 
	}
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		return service.getAllUsers(); 
	}
	
	@PostMapping("/login")
	public String insertUser(@RequestBody UserRequest userRequest) {
		JwtUtil jwt=new JwtUtil();
		return jwt.generateToken(userRequest);
		//return service.saveUser(new User(userRequest)); 
	}
}
