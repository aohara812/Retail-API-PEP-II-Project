//package com.cognixa.jump.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cognixa.jump.model.User;
//import com.cognixa.jump.repository.UserRepository;
//
//@RestController
//@RequestMapping("/api")
//public class PurchasingController {
//	
//	@Autowired
//	UserRepository repo;
//	
//	@Autowired
//	PasswordEncoder encoder;
//
//	
//	@GetMapping("/user")
//	public List<User> getUsers() {
//		return repo.findAll();
//	}
//	
//	
//	@PostMapping("/user")
//	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
//		
//		
//		user.setId(null);
//		
//		// each password for a new user gets encoded
//		user.setPassword( encoder.encode( user.getPassword() ) );
//		
//		User created = repo.save(user);
//		
//		return ResponseEntity.status(201).body(created);
//	}
//	
//	
//	
//	// Update purchasing transaction
//	@PutMapping("/addpurchase")
//	public ResponseEntity<?> addpurchase(@RequestBody PurchaseAndUserReqModel model) {
//		
//	}
//		if (service.) {
//			return new ResponseEntity<>("update transaction", HttpStatus.CREATED);
//		}
//	return new ResponseEntity<>("Failed to make purchase.", HttpStatus.NOT_ACCEPTABLE);
//	
//	
//	
//}
