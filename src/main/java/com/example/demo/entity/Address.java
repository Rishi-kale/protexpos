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
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long address_id;
	private String houseNo;
	private String area;
	private String city;
	private String state;
	private int pincode;
	

	
	@OneToMany(mappedBy ="ad",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<User> user;
	
	
	public Address(Long address_id, String houseNo, String area, String city, String state, int pincode) {
		super();
		this.address_id = address_id;
		this.houseNo = houseNo;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public Address() {
		super();
	}
	public Long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public List<User> getUser(List<User> user) {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
	
	

}
