package com.var.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.var.entity.Product;

@Repository  // Repository   -> CrudRepository -> PagingandSortingRepository ->JPARedpositoty
public interface ProductRepository  extends CrudRepository<Product,Integer>{
	// save, findById(), findAll,deleteById,...

}
