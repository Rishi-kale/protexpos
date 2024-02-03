package com.example.demo.Service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.CartRepository;
import com.example.demo.Respository.ProductRepository;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;

@Service
public class CartServiceImpl implements CartServiceInterface {
	@Autowired
	private CartRepository cr;
	@Autowired
	private ProductRepository pr;


	@Override
	public String addItemCart(Cart c) {
		          
		   
            Product p= pr.findById(c.getCart_products()).get();
            Long price=p.getProduct_price()*c.getCart_itemQuantity();
            c.setTotalCartPrice(price);
            cr.save(c);
          
		
		return "cart saved succesfully"; 
	}


	@Override
	public String updateCart(Cart c) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteallcart() {
		cr.deleteAll();
		return "deleted all items in cart" ;
	}


	@Override
	public Cart getcartbyid(Long cart_id) {
		    Cart c=cr.findById(cart_id).get();
		return c;
	}

}
