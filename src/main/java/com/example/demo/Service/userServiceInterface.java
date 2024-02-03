package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.User;

public interface userServiceInterface {
	String signup(User user,Long id);
	String deleteUser(long id);
	String updateUser(User user,long id);
	List<User> getAllUser();
	Optional<User> getUserById(long id);
	String login(String id,String pass);
//	UserDetailsService userDetailsService();

}
