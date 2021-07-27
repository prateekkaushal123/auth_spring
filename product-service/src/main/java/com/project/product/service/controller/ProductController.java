package com.project.product.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class ProductController {

	@GetMapping("/health")
	public String respond() {
		log.info("Product controller /health called");
		return "Hello from product service. Service is up"; 
	}
}
