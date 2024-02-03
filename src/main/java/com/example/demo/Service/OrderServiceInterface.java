package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;

public interface OrderServiceInterface {
	
	String PlaceOrder(Long id);
	List<Order> getorder();
	String deleteOrder(Long id);
	String UpdateOrder(Cart c,Long id);
	String discount(Long id,Long percent);

}
