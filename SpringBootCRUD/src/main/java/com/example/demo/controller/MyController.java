package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.MyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class MyController {
	
	@Autowired
	private MyService serv;
	
	@GetMapping("/allProducts")
	public List<Product> getMethodName() {
		
		return serv.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id){
		
		return serv.fetchProductById(id).get();
		
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product prod) {
		//TODO: process POST request
		
		return serv.saveProduct(prod);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product prod) {
		//TODO: process POST request
		
		return serv.saveProduct(prod);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProductById(@PathVariable int id) {
		 
		return serv.deleteById(id);
	}
	
	
}
