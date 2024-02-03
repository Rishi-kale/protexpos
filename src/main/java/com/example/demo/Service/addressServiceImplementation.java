package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.addressRepository;
import com.example.demo.entity.Address;

@Service
public class addressServiceImplementation implements addressServiceInterface{
	
	@Autowired
	private addressRepository addressRepo;

	@Override
	public String takeadress(Address a) {
		addressRepo.save(a);
		return "succesfully saved";
	}

	@Override
	public String deleteadress(long id) {
		addressRepo.deleteById(id);
		return "succesfully deleted";
	}

	@Override
	public String updateadress(Address c, long id) {
		
		Optional<Address> l=addressRepo.findById(id);
		if(l.isPresent()) {
			Address u=l.get();
			u.setArea(c.getArea());
			u.setCity(c.getCity());
			u.setHouseNo(c.getHouseNo());
			u.setPincode(c.getPincode());
			u.setState(c.getState());
			
			return "Succesfully Updated";
		}
 		 return null;
	}

	@Override
	public Optional<Address> getAddressById(long id) {	
		return addressRepo.findById(id);
	}

}
