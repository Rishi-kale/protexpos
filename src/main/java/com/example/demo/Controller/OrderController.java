package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.OrderServicImpl;

import com.example.demo.entity.Order;

//import jakarta.persistence.criteria.Order;


@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderServicImpl orderimpl;
	
	@PostMapping("/createorder/{id}")
	public String addorder(@PathVariable  Long id) {
	     return orderimpl.PlaceOrder(id);
	}
	@GetMapping("/getorder")
	public List<Order> getAllCate() {
		 return orderimpl.getorder();
	}
	@DeleteMapping("/delorder/{id}")
	public String DeleteCategory(@PathVariable Long id ) {
		return orderimpl.deleteOrder(id);
	}
	@PutMapping("/discount/{id}/{percentage}")
	public String discount(@PathVariable Long id,@PathVariable Long percentage) {
		return orderimpl.discount(id, percentage);
	}
//	@PutMapping("/updateorder/{id}")
//	public String UpdateCategory(@RequestBody Categories category, @PathVariable Long id) {
//		
//		return cateServiceInterface.UpdateCategory(category, id);
//	}

}
