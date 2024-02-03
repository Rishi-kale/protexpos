package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.FeedbackServiceInterface;
import com.example.demo.entity.Feedback;


@RestController
@RequestMapping("/api")
public class FeedbackController {
	@Autowired
	private FeedbackServiceInterface  fs;
	
	@PostMapping("/givefeedback/{uid}")
	public ResponseEntity<String> addinguser(@RequestBody Feedback f,@PathVariable Long uid){ 
		     
		String msg = fs.givefeedback(f,uid);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteFeedback/{id}")
	public ResponseEntity<String> deletinguser(@PathVariable long id){
		String msg = fs.deletefeedback(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
		
	@PutMapping("/updatefeedback/{id}")
	public ResponseEntity<String> updatefeedback(@RequestBody Feedback f,@PathVariable long id){
		String msg = fs.updatefeedback(f, id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	@GetMapping("/getallfeedback")
	public List<Feedback> gettingallfeedback(){
		return fs.getallfeedback();
		
	}

}
