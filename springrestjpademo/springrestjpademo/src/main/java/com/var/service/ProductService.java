package com.var.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.var.entity.Product;
import com.var.exception.ProductNotFoundException;
import com.var.exception.ResourceNotFoundException;
import com.var.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	//@Transactional
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	public List<Product> getAllProducts() {
		return (List)productRepository.findAll();
	}
	public Product getProduct(Integer id) throws ProductNotFoundException{
		 Product product2=productRepository.findById(id).orElseThrow(() -> new 
				 ProductNotFoundException());
		return product2;
	}
	//@Transactional
	public void  deleteProduct(Integer id) throws ProductNotFoundException{
		 Product product2=productRepository.findById(id).orElseThrow(() -> new 
				 ProductNotFoundException()); 
		if(product2!=null)
		 productRepository.deleteById(id);  //commit, rollback
	}
	//@Transactional   //Exception using ResponseStatusException
	public void  updateProduct(Integer id,Product product) throws ResourceNotFoundException {
		// Product product1=productRepository.findById(id).get();
		 Product product2=productRepository.findById(id).orElseThrow(() -> new 
				 ResourceNotFoundException("Product", "id", id)); 
			
		 product2.setName(product.getName());
	}

}
