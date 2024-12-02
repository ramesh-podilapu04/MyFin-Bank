package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
			result="Record deleted ..";

		} catch (Exception e) {
			
			result="Record not found";
		}
		return result;
	}

}
