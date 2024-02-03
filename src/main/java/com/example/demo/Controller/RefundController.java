package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ReturnServiceInterface;
import com.example.demo.entity.ReturnAndRefund;


@RestController 
@RequestMapping("/api")
public class RefundController {
	
	@Autowired
	private ReturnServiceInterface rsi;
	
	 @PostMapping("/return/{i}") // Map ONLY POST Requests
	 public ResponseEntity<String> addNewProduct (@RequestBody ReturnAndRefund id,@PathVariable Long i ) { 
		 String msg= rsi.returnitem(id,i);
					
	    return new ResponseEntity<String>(msg,HttpStatus.OK);
	
	  }

}
