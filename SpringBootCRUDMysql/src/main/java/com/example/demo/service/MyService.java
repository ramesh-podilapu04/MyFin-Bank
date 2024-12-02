package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.MyRepo;

@Service
public class MyService {

	@Autowired
	private MyRepo repo;

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Optional<Product> fetchProductById(int id) {

		return repo.findById(id);
	}

	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	public String deleteById(int id) {
		String result;
		try {
			repo.deleteById(id);
			result = "Record deleted ..";

		} catch (Exception e) {

			result = "Record not found";
		}
		return result;
	}
	
	public Page<Product> fetchFirstThreeProducts() {
		Pageable firstThree = PageRequest.of(0, 3);
		
		return repo.findAll(firstThree);
		
	}
	
	public Page<Product> fetchNextTwoProducts() {
		
		Pageable pageable = PageRequest.of(1, 2);
		
		return repo.findAll(pageable);
	}
	
	public Page<Product> fetchCustomPageProducts(int pageNumber, int noOfProducts) {
		
		Pageable pageable = PageRequest.of(pageNumber, noOfProducts);
		return repo.findAll(pageable);
	}
	
	public List<Product> fetchProductsByDirectionOrderAndPropertyName(Direction direction,String propery) {
		
		return repo.findAll(Sort.by(direction, propery));
	}
	
	public List<Product> fetchProductsWithNullNameValues(){
		return repo.fetchProductsWithNullNameValues();
	}
	
	public Page<Product> fetchProductsByPagedAndSorted(int pageNumber,int pageSize,Direction direction,String properties) {
		Pageable page= PageRequest.of(pageNumber, pageSize, direction, properties);
		return repo.findAll(page);
	}

	public void deleteAll() {
		 repo.deleteAll();
	}
}
