package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Product;

public interface MyRepo extends JpaRepository<Product, Integer> {

	@Query(value="SELECT * from Product Where name is Null or name =''",nativeQuery=true)
	List<Product> fetchProductsWithNullNameValues();
	
	void deleteAll();
}
