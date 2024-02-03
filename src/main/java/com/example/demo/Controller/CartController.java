package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.CartServiceInterface;
import com.example.demo.entity.Cart;

@RestController
@RequestMapping("/api")
public class CartController {
	
	@Autowired
	private CartServiceInterface cartService;
	
	@PostMapping("/addtocart")
	public String addProductToCart(@RequestBody Cart c){
		String msg=cartService.addItemCart(c);
		return msg;
	}
	@DeleteMapping("/deleteallcart")
	public String deleteallitemcart() {
		 return cartService.deleteallcart();
	}
	@GetMapping("/getcartbyid/{id}")
	public Cart getitemscart(@PathVariable Long id) {
		return cartService.getcartbyid(id);
	}

}
