package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface ProductServiceInterface {
	
	String createNewProduct(Product p, Long id);
	List<Product> getProductList();
	public Optional<Product> getProductByid(Long id);
	String deletebyid(Long id);
	String update(Product u, Long id);
	

}
