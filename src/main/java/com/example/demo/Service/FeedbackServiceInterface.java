package com.example.demo.Service;

import java.util.List;


import com.example.demo.entity.Feedback;

public interface FeedbackServiceInterface {
	String givefeedback(Feedback f,Long uid);
	String deletefeedback(long id);
	String updatefeedback(Feedback f,long id);
	List<Feedback> getallfeedback();

}
