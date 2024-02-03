package com.example.demo.Service;

import java.util.Optional;

import com.example.demo.entity.Address;

public interface addressServiceInterface {
	String takeadress(Address a);
	String deleteadress(long id);
	String updateadress(Address user,long id);
	Optional<Address> getAddressById(long id);

}
