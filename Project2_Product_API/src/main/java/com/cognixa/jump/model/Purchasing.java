//package com.cognixa.jump.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.ManyToOne;
//
//import org.springframework.data.annotation.Id;
//
//@Entity
//public class Purchasing {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY )
//	private Integer id;
//	
//	@ManyToOne
//	private Product product;
//	
//	@ManyToOne
//	private int user;
//	
//	
//	@Column(nullable = false)
//	private int qty;
//	
//	public Purchasing() {
//		
//	}
//
//	public Purchasing(Integer id, String name, double price, int qty) {
//		super();
//		this.id = id;
//		this.product = product;
//		this.user = user;
//		this.qty = qty;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public int getUser() {
//		return user;
//	}
//
//	public void setUser(int user) {
//		this.user = user;
//	}
//
//	public int getQty() {
//		return qty;
//	}
//
//	public void setQty(int qty) {
//		this.qty = qty;
//	}
//
//	@Override
//	public String toString() {
//		return "Purchasing [id=" + id + ", product=" + product + ", user=" + user + ", qty=" + qty + "]";
//	}
//	
//	
//
//}