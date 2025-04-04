package com.var.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.var.dto.ProductDTO;
import com.var.entity.Product;

@RestController
public class ProductClientController {//consumer

	

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/client")
	 public String consume() {
		ResponseEntity<Product> resource= restTemplate.getForEntity("http://localhost:8082/product/181", Product.class);
		 return resource.getBody().toString();
	 }

	

}
