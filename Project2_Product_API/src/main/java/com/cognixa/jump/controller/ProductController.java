package com.cognixa.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixa.jump.exception.ItemNotFoundException;
import com.cognixa.jump.exception.ResourceNotFoundException;
import com.cognixa.jump.model.Product;
import com.cognixa.jump.repository.ProductRepository;

@RequestMapping("/api")
@RestController
public class ProductController {
	
	@Autowired
	ProductRepository repo;
	
	@GetMapping("/product")
	public List<Product> getProducts() {
		return repo.findAll();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProduct(@PathVariable int id) throws ItemNotFoundException {
		
		Optional<Product> found = repo.findById(id);
		
		if(found.isEmpty()) {
			throw new ItemNotFoundException( id);
		}
		
		return ResponseEntity.status(200).body(found.get());
	}
	
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		
		product.setId(-1);
		
		Product created = repo.save(product);
		
		return ResponseEntity.status(201).body(created);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) throws ItemNotFoundException {
		
		Optional<Product> found = repo.findById(id);
		
		if( found.isEmpty() ) {
			
			throw new ItemNotFoundException(id);
		}
		
		repo.deleteById(id);
		
		return ResponseEntity.status(200).body(found.get());
	}
	
	@PutMapping("/product/")
	public ResponseEntity<?> updateProduct(@RequestBody Product product) throws ResourceNotFoundException {
		
		if(repo.existsById(product.getId())) {
			
			
			Product updated = repo.save(product);
			
			return ResponseEntity.status(200).body(updated);
		}
		
		throw new ResourceNotFoundException("Not Found");
	}
	
}