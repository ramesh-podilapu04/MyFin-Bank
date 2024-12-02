package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.MyService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/products")
public class MyController {

	@Autowired
	private MyService serv;

	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Product> getAllProducts() {

		return serv.getAllProducts();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Product getProductById(@PathVariable int id) {

		return serv.fetchProductById(id).get();

	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Product addProduct(@RequestBody Product prod) {
		// TODO: process POST request

		return serv.saveProduct(prod);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Product updateProduct(@RequestBody Product prod) {
		// TODO: process POST request

		return serv.saveProduct(prod);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteProductById(@PathVariable int id) {

		return serv.deleteById(id);
	}

	@DeleteMapping("/deleteAll")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAllProducts()
	{
		 serv.deleteAll();
	}
//	@GetMapping("/firstThree")
//	public Page<Product> getThree() {
//
//		return serv.fetchFirstThreeProducts();
//	}
//
//	@GetMapping("/nextTwo")
//	public Page<Product> getNextTwo() {
//		return serv.fetchNextTwoProducts();
//	}
//
//	@GetMapping("/customPageProducts")
//	public Page<Product> getCustomPageProducts() {
//		return serv.fetchCustomPageProducts(2, 1);
//	}
//
//	@GetMapping("/getProductsByLatestAddedOrder")
//	public List<Product> getProductsByLatestAddedOrder() {
//		return serv.fetchProductsByLatestAddedOrder();
//	}
//
//	@GetMapping("/fetchProductsWithNullNameValues")
//	public List<Product> getProductsWithNullNameValues() {
//		return serv.fetchProductsWithNullNameValues();
//	}

}
