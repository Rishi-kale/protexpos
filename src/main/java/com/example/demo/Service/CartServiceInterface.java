package com.example.demo.Service;

import com.example.demo.entity.Cart;

public interface CartServiceInterface {
	
	String addItemCart(Cart c);
	String updateCart(Cart c);
	String deleteallcart();
	Cart getcartbyid(Long cart);
	

}
