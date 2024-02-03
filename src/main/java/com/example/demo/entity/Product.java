package com.example.demo.entity;

 import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Product_table")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long	Product_id;
	@Column(name = "Product_description",nullable = false, length = 30)
	private String	Product_description;
	@Column(name = "Product_price",nullable = false )
	private Long	Product_price;
	@Column(name = "Product_quantity",nullable = false )
	private Integer	Product_quantity;
	@Column(name = "Product_imageURL",length = 50 )
	private String Product_imageURL;
	
	private String Product_name;
	

	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="Category_id")
	 private Categories category;
	 
	
	
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public Product(Long product_id, String product_description, Long product_price, Integer product_quantity,
			String product_imageURL,String product_name) {
		super();
		Product_id = product_id;
		Product_description = product_description;
		Product_price = product_price;
		Product_quantity = product_quantity;
		Product_imageURL = product_imageURL;
		Product_name = product_name;
	}
	
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public Long getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(Long product_id) {
		Product_id = product_id;
	}
	public String getProduct_description() {
		return Product_description;
	}
	public void setProduct_description(String product_description) {
		Product_description = product_description;
	}
	public Long getProduct_price() {
		return Product_price;
	}
	public void setProduct_price(Long product_price) {
		Product_price = product_price;
	}
	public Integer getProduct_quantity() {
		return Product_quantity;
	}
	public void setProduct_quantity(Integer product_quantity) {
		Product_quantity = product_quantity;
	}
	public String getProduct_imageURL() {
		return Product_imageURL;
	}
	public void setProduct_imageURL(String product_imageURL) {
		Product_imageURL = product_imageURL;
	}
	public Product() {
		super();
	}
	
	
	
}