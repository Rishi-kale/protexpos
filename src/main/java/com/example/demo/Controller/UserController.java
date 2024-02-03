package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.Service.userServiceImplementation;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private userServiceImplementation userimple;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addinguser(@RequestBody User user){ 
		     Long x=user.getAd().getAddress_id();
		String msg = userimple.signup(user, x);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deletinguser(@PathVariable long id){
		String msg = userimple.deleteUser(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}@GetMapping("/getallUser")
	public ResponseEntity<List<User>> addinguser(){
		List<User> msg = userimple.getAllUser();
		return new ResponseEntity<List<User>>(msg,HttpStatus.OK);
		
	}@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateinguser(@RequestBody User user,@PathVariable long id){
		String msg = userimple.updateUser(user, id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	@GetMapping("/getUserById/{id}")
	public Optional<User> gettinguserById(@PathVariable long id){
		
		return userimple.getUserById(id);
		
	}
	@PostMapping("/login/{id}/{pass}")
	public String login(@PathVariable String id,@PathVariable String pass) {
		return userimple.login(id, pass);
	}
	

}
