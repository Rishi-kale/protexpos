package com.example.demo.entity;


//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long User_id;	
	private String user_firstName;	
	private String user_lastName;
	private int User_age;
	@Column(name = "User_email",unique = true )
	private String User_email;
	private String User_password;
	private Long user_contactNumber;
//	private User_Role user_role;
	private String user_role;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="address_id")
	 private Address ad ;
	
	
	@OneToOne(mappedBy = "u", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    private Cart cart;
	
	
	@OneToOne(mappedBy ="fb",fetch = FetchType.EAGER)
	 private Feedback fbs ;

	public Long getUser_id() {
		return User_id;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public void setUser_id(Long user_id) {
		User_id = user_id;
	}

	public Address getAd() {
		return ad;
	}

	public void setAd(Address ad) {
		this.ad = ad;
	}

	public User() {
		super();
	}

	public String getUser_firstName() {
		return user_firstName;
	}

	public void setUser_firstName(String user_firstName) {
		this.user_firstName = user_firstName;
	}

	public String getUser_lastName() {
		return user_lastName;
	}

	public void setUser_lastName(String user_lastName) {
		this.user_lastName = user_lastName;
	}

	public int getUser_age() {
		return User_age;
	}

	public void setUser_age(int user_age) {
		User_age = user_age;
	}

	public String getUser_email() {
		return User_email;
	}

	public void setUser_email(String user_email) {
		User_email = user_email;
	}

	public String getUser_password() {
		return User_password;
	}

	public void setUser_password(String user_password) {
		User_password = user_password;
	}

	public Long getUser_contactNumber() {
		return user_contactNumber;
	}

	public void setUser_contactNumber(Long user_contactNumber) {
		this.user_contactNumber = user_contactNumber;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public User(Long user_id, String user_firstName, String user_lastName, int user_age, String user_email,
			String user_password, Long user_contactNumber, String user_role) {
		super();
		User_id = user_id;
		this.user_firstName = user_firstName;
		this.user_lastName = user_lastName;
		User_age = user_age;
		User_email = user_email;
		User_password = user_password;
		this.user_contactNumber = user_contactNumber;
		this.user_role = user_role;
		
		
	}


//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		return List.of(new SimpleGrantedAuthority(user_role.name()));
//	}
	
//
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return User_email;
//	}
//
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}

//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
