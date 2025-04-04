package com.var.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(name="igproduct2")
public class Product { //productData   product_Data
	@Id
	@Column(name="product_id")
	//@NotBlank
	Integer id;
	@Column(name="product_name")
	//@NotBlank
	String name;// name_of_product
	public Product(){}
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
	public Product(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
