package com.example.demo.entity;





import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;


@Entity
public class Cart {
	 
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long Cart_id;
	 private Long Cart_products;
	 private Long cart_itemQuantity;
     private Long totalCartPrice;
     
     @OneToOne(fetch = FetchType.EAGER)
     @JsonBackReference
 	  private User u;

     @OneToOne(mappedBy = "ca", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	  private Order o;

	public Cart(Long cart_id, Long cart_products, Long cart_itemQuantity, Long totalCartPrice, User u) {
		super();
		Cart_id = cart_id;
		Cart_products = cart_products;
		this.cart_itemQuantity = cart_itemQuantity;
		this.totalCartPrice = totalCartPrice;
		this.u = u;
	}

	public Long getCart_id() {
		return Cart_id;
	}

	public void setCart_id(Long cart_id) {
		Cart_id = cart_id;
	}

	public Long getCart_products() {
		return Cart_products;
	}

	public void setCart_products(Long cart_products) {
		Cart_products = cart_products;
	}

	public Long getCart_itemQuantity() {
		return cart_itemQuantity;
	}

	public void setCart_itemQuantity(Long cart_itemQuantity) {
		this.cart_itemQuantity = cart_itemQuantity;
	}

	public Long getTotalCartPrice() {
		return totalCartPrice;
	}

	public void setTotalCartPrice(Long totalCartPrice) {
		this.totalCartPrice = totalCartPrice;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Cart() {
		super();
	}
    



}
