package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.CartRepository;
import com.example.demo.Respository.OrderRepository;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Order;

@Service
public class OrderServicImpl implements OrderServiceInterface{
	@Autowired
	private OrderRepository or;
	
	@Autowired
	private CartRepository cr;

	@Override
	public String PlaceOrder(Long id) {
		      Order o = new Order();
		      Optional<Cart> c = cr.findById(id);
		      Cart ca=c.get();
		      
		      o.setAmount(ca.getTotalCartPrice());
		      o.setStatus("pending");
		      o.setOrderdate("1/1/2023");
		      o.setDeliverydate("soon");
		      o.setCa(ca);
		      or.save(o);
		return "proceed to payment";
	}

	@Override
	public List<Order> getorder() {
		 
		return or.findAll();
	}

	@Override
	public String deleteOrder(Long id) {
		  or.deleteById(id);
		return "order deleted sucessfully";
	}

	@Override
	public String UpdateOrder(Cart c, Long id) {
		// TODO Auto-generated method stub
		return "order updated succefully";
	}

	@Override
	public String discount(Long id, Long percent) {
		  Optional<Order> o=or.findById(id);
		  Order a =o.get();
		  long p=a.getAmount();
		  a.setAmount(p-(p*percent)/100);
		  or.save(a);
		return "discount applied";
	}
	

}
