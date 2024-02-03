package com.example.demo.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Respository.CategoryRespository;
import com.example.demo.Respository.ProductRepository;
import com.example.demo.entity.*;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductUserImplement implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private CategoryRespository cr;
    

    @Override
    public String createNewProduct(Product product,Long id) {
    	Categories i = cr.findById(id).get();
    	product.setCategory(i);
        productRepo.save(product);
        return "Successfully new product is added!!!!";
    }

	@Override
	public List<Product> getProductList() {
		
		List<Product> allproducts=productRepo.findAll();
		return allproducts;
		
	}

	@Override
	public Optional<Product> getProductByid(Long id) {
		return productRepo.findById(id);
	}

	@Override
	public String deletebyid(Long id) {
		productRepo.deleteById(id);
		return "succesfully deleted";
	}

	@Override
	public String update(Product u,Long id) {
//		List<Product> list = new ArrayList<Product>();
		Optional<Product> l=productRepo.findById(id);
//		list=getProductList();
//		for(Product p:list) {
			if(l.isPresent()) {
				Product p=l.get();
				p.setProduct_name(u.getProduct_name());
				p.setProduct_imageURL(u.getProduct_imageURL());
				p.setProduct_price(u.getProduct_price());
				p.setProduct_description(u.getProduct_description());
			    productRepo.save(p);   
				return "updated sucessfully";
//			}
		}
        
		return null;
	}

	
}
	


