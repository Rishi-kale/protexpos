package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Respository.addressRepository;
import com.example.demo.Respository.userRepository;
import com.example.demo.entity.Address;

import com.example.demo.entity.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class userServiceImplementation implements userServiceInterface {

	@Autowired
	private userRepository userRepo;
	@Autowired
	private addressRepository addressRespo;

//	public UserDetailsService userDetailsService() {
//		return new UserDetailsService() {
//
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//				return userRepo.findbyEmail(username)
//						.orElseThrow(() -> new UsernameNotFoundException("user not found"));
//			}
//		};
//
//	}

	@Override
	public String deleteUser(long id) {
		userRepo.deleteById(id);
		return "Delete sucessfully";
	}

	@Override
	public String updateUser(User c, long id) {

		Optional<User> l = userRepo.findById(id);
		if (l.isPresent()) {
			User u = l.get();
			u.setUser_age(c.getUser_age());
			u.setUser_contactNumber(c.getUser_contactNumber());
			u.setUser_email(c.getUser_email());
			u.setUser_firstName(c.getUser_firstName());
			u.setUser_lastName(c.getUser_lastName());
			u.setUser_role(c.getUser_role());
			u.setUser_password(c.getUser_password());
			userRepo.save(u);
			return "Succesfully Updated";
		}
		return null;

	}

	@Override
	public List<User> getAllUser() {

		List<User> u = userRepo.findAll();
		return u;
	}

	@Override
	public Optional<User> getUserById(long id) {

		return userRepo.findById(id);
	}

	@Override
	public String login(String id, String pass) {
		List<User> u = userRepo.findAll();
		for (User i : u) {
			if (i.getUser_email().equals(id)) {
				if (i.getUser_password().equals(pass))
					return "sucessfully login";
			}

		}

		return "invlaid user or password";
	}

	@Override
	public String signup(User user, Long id) {
		Optional<Address> a=addressRespo.findById(id);
		Address x=a.get();
		user.setAd(x);
		userRepo.save(user);
		return "saved succesfully";
	}

	

}
