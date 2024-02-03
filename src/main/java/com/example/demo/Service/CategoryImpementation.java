package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.CategoryRespository;
import com.example.demo.entity.Categories;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryImpementation implements CategoryServiceInterface{
	@Autowired
    private CategoryRespository Category;
	
	@Override
	public List<Categories> getAllCategory() {
		List<Categories > c= Category.findAll();
			return c;
		
	}

	@Override
	public String addCategory(Categories cate) {
		Category.save(cate);
		return "Added Successfully";
		
	}
	@Override
	public String DeleteCategory(Long id) {
		Category.deleteById(id);
		return "Delete Successfully";
	}
	@Override
	public String UpdateCategory(Categories category, Long id) {
	    Optional<Categories> t= Category.findById(id);
	    if(t.isPresent()) {
	    	Categories temp = t.get();
	    	temp.setCatname(category.getCatname());
	    	Category.save(temp);
	    	
	    }
	    else
	    	return "NO Category Found";
		return "updated Succesfully ";
	}

}
