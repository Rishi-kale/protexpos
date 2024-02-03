package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Order_table")
public class Order {     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long OrderId;
	private String Status;
	private Long amount;
	private String orderdate;
	private String deliverydate;
	
	@OneToOne(mappedBy ="oid",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private ReturnAndRefund re;

	public Order() {
		super();
	}

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long long1) {
		this.amount = long1;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public Cart getCa() {
		return ca;
	}

	public void setCa(Cart ca) {
		this.ca = ca;
	}

	public Order(Long orderId, String status, Long amount, String orderdate, String deliverydate, Cart ca) {
		super();
		OrderId = orderId;
		Status = status;
		this.amount = amount;
		this.orderdate = orderdate;
		this.deliverydate = deliverydate;
		this.ca = ca;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Cart_id")
    private Cart ca;
	
 
}
