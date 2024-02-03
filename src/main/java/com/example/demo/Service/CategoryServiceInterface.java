package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Categories;

public interface CategoryServiceInterface  {
	public List<Categories> getAllCategory();
	public String addCategory(Categories cate);
	public String DeleteCategory(Long id);
    public String UpdateCategory(Categories category, Long id);

}
