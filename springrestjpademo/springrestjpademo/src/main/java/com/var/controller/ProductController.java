package com.var.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.var.dto.ProductDTO;
import com.var.entity.Product;
import com.var.exception.ProductNotFoundException;
import com.var.service.ProductService;

import jakarta.validation.Valid;
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	ModelMapper modelMapper;
	@PostMapping("/product") // http://localhost:8082/product
	public String  addProduct( @RequestBody ProductDTO productDto)
	{   Product product=modelMapper.map(productDto, Product.class);
		productService.addProduct(product);
		return "Added";
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<String>  addProduct1(@RequestBody ProductDTO productDto)
	{   Product product=modelMapper.map(productDto, Product.class);
		productService.addProduct(product);
		return new ResponseEntity<>("Created",HttpStatus.CREATED);
	}
	
	@GetMapping("/product/{id}")
	public ProductDTO getProduct(@PathVariable("id") Integer id) throws ProductNotFoundException{
		Product product=productService.getProduct(id);
		return modelMapper.map(product, ProductDTO.class);
	}
	@GetMapping("/product")
	public List<ProductDTO> getAllProducts() {
		List<Product> productList= productService.getAllProducts();
		return productList.stream().map(Product->modelMapper.map(Product,ProductDTO.class)).collect(Collectors.toList());
		
	}
	@PutMapping("/product/{id}")
	public String updateProduct(@PathVariable("id") Integer id,@RequestBody ProductDTO productDto)  throws Exception{
		 productService.updateProduct(id,modelMapper.map(productDto, Product.class));
		 return "updated";
	}
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable("id") Integer id) throws ProductNotFoundException {
		 productService.deleteProduct(id);
		 return "deleted";
	}
}
