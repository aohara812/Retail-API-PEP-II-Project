//package com.cognixa.jump.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import com.cognixa.jump.exception.ResourceNotFoundException;
//import com.cognixa.jump.model.Purchasing;
//import com.cognixa.jump.repository.PurchasingRepository;
//import com.cognixa.jump.repository.UserRepository;
//import com.cognixa.jump.model.User;
//
//public class PurchasingService {
//
//	@Autowired
//	PurchasingRepository purchasingRepo;
//
//	@Autowired
//	UserRepository userRepo;
//	
//	public List<Purchasing> Purchase(){
//		
//		return purchasingRepo.findAll();
//		
//	}
//	
//	public List<User> findUserbyName(String username, String password)
//			throws ResourceNotFoundException {
//		
//		List<User> search = userRepo.findUserByusernameAndpassword(username, password);
//		return search;
//	}
//	
//		public boolean addPurchaseToUser(Long purchaseId, Long userId) {
//			
//			Optional<Purchasing> purchasingAdd = purchasingRepo.findById(purchaseId);
//			Optional<User> studentAdd = userRepo.findById(userId);
//			
//			if (purchasingAdd.isPresent() && studentAdd.isPresent()) {
//				
//				purchasingAdd.get().addUser(userAdd.get());
//				studentAdd.get().setPurchasing(purchasingAdd.get());
//			
//				purchasingRepo.save(purchasingAdd.get());
//				userRepo.save(userAdd.get());
//			
//				return true;
//		}
//			
//	}
//	
//	
//
//}
