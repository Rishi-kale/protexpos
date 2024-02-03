package com.example.demo.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.*;
import com.example.demo.entity.*;


@RestController // This means that this class is a Controller
@RequestMapping("/api") // This means URL's start with /demo (after Application path)
public class ProductController {
	@Autowired
	 private  ProductServiceInterface productinter;
//	ProductUserImplement n=new ProductUserImplement();
	
	 @PostMapping("/add/{id}") // Map ONLY POST Requests
	 public ResponseEntity<String> addNewProduct (@RequestBody Product product,@PathVariable Long id ) { 
		
				String msg=productinter.createNewProduct(product,id);	
	    return new ResponseEntity<String>(msg,HttpStatus.OK);
	
	  }
	 @GetMapping("/getallProduct")
	 public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> p=productinter.getProductList();
		 return new ResponseEntity<List<Product>>(p,HttpStatus.OK);
	 }
	 
	 @GetMapping("/get/{id}")
	 public ResponseEntity<Product> getProductbyId(@PathVariable Long id){
		Optional<Product> i=productinter.getProductByid(id);
		 return new ResponseEntity<Product>(i.get(),HttpStatus.OK);
	 }
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> deleteByid(@PathVariable Long id) {
		  String msg=productinter.deletebyid(id);
		  return new ResponseEntity<String>(msg,HttpStatus.OK);
	  }
	  @PutMapping("/update/{id}")
	  public ResponseEntity<String> updateProduct(@RequestBody Product product,@PathVariable Long id){
		  String msg=productinter.update(product, id);
		  return new ResponseEntity<String>(msg,HttpStatus.OK);
	  }
	 
}
