package com.var.dto;
import jakarta.validation.constraints.NotNull;

public class ProductDTO { //productData   product_Data
	//@NotNull
	Integer id;
	//@NotNull
	String name;// name_of_product
	public ProductDTO(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	public ProductDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	}
