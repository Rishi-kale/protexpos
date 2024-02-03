package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CategoryServiceInterface;
import com.example.demo.entity.Categories;
@RestController
@RequestMapping("/apii")
public class CategoryController {
	@Autowired
	private CategoryServiceInterface cateServiceInterface;
	@PostMapping("/addcategory")
	public String addCategory(@RequestBody Categories cate) {
	     return 	cateServiceInterface.addCategory(cate);	
	}
	@GetMapping("/getcategory")
	public List<Categories> getAllCate() {
		 return cateServiceInterface.getAllCategory();
	}
	@DeleteMapping("/delcategory/{id}")
	public String DeleteCategory(@PathVariable Long id ) {
		return cateServiceInterface.DeleteCategory(id);
	}
	@PutMapping("/updatecategory/{id}")
	public String UpdateCategory(@RequestBody Categories category, @PathVariable Long id) {
		
		return cateServiceInterface.UpdateCategory(category, id);
	}








}
