package com.example.demo.entity;


import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories_table")
public class Categories {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	Category_id;
	private String catname;
	private String Category_description;
	private Boolean category_activeStatus;
	
	
	@OneToMany(mappedBy ="category",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Product> product;


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	public Categories(Long category_id, String catname, String category_description, Boolean category_activeStatus) {
		super();
		Category_id = category_id;
		this.catname = catname;
		Category_description = category_description;
		this.category_activeStatus = category_activeStatus;
	}


	public Long getCategory_id() {
		return Category_id;
	}


	public void setCategory_id(Long category_id) {
		Category_id = category_id;
	}


	public String getCatname() {
		return catname;
	}


	public void setCatname(String catname) {
		this.catname = catname;
	}


	public String getCategory_description() {
		return Category_description;
	}


	public void setCategory_description(String category_description) {
		Category_description = category_description;
	}


	public Boolean getCategory_activeStatus() {
		return category_activeStatus;
	}


	public void setCategory_activeStatus(Boolean category_activeStatus) {
		this.category_activeStatus = category_activeStatus;
	}


	public Categories() {
		super();
	}
	
	
}