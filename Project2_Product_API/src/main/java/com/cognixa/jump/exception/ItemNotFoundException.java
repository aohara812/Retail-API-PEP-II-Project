package com.cognixa.jump.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognixa.jump.model.User;

 
public class ItemNotFoundException extends Exception {
	// Exception class
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	public ItemNotFoundException(int id) {
		super("Item not Found with id = " + id);
		
	
	}
	

}
