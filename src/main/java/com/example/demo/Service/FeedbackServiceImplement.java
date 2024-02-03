package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Respository.FeedbackRepository;
import com.example.demo.Respository.userRepository;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.User;

@Service
public class FeedbackServiceImplement implements FeedbackServiceInterface {
	
	@Autowired
	private FeedbackRepository fr;
	@Autowired
	private userRepository ur;

	@Override
	public String givefeedback(Feedback f,Long uid) {
		Optional<User> u=ur.findById(uid);
		if(u.isPresent()) {
		User o= u.get();
		f.setUser(o);
		fr.save(f);
		return "save succefully";
		}
		return null;
	}

	@Override
	public String deletefeedback(long id) {
		fr.deleteById(id);
		return "deleted sucessfully";
	}

	@Override
	public String updatefeedback(Feedback f, long id) {
		Optional<Feedback> x=fr.findById(id);
		if(x.isPresent()) {
			Feedback u=x.get();
			u.setFeedback_description(f.getFeedback_description());
			u.setFeedback_submitDate(f.getFeedback_submitDate());
			return "Succesfully Updated";
		}
 		 return null;
	}

	@Override
	public List<Feedback> getallfeedback() {
		List<Feedback> l=fr.findAll();
		return l;

}
}
