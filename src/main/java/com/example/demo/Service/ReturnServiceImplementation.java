package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.OrderRepository;
import com.example.demo.Respository.ReturnRepository;
import com.example.demo.entity.Order;
import com.example.demo.entity.ReturnAndRefund;

@Service
public class ReturnServiceImplementation implements ReturnServiceInterface{
	
	@Autowired
	private ReturnRepository rdb;
	
	@Autowired 
	private OrderRepository odb;

	@Override
	public String returnitem(ReturnAndRefund oid,Long i) {
		Optional<Order> o= odb.findById(i);
		if(o.isPresent()) {
		Order x=o.get();
		oid.setOrderidd(x);
		odb.deleteById(i);
		rdb.save(oid);
		return "item return succesfully";
		}
		return "item not found";
	}

}
