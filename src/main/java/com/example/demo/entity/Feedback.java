package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback_table")
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long feedback_id;
	private String feedback_description;
	private String feedback_submitDate;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="User_id")
	private User fb;

	public Feedback(String feedback_description, String feedback_submitDate) {
		super();
		this.feedback_description = feedback_description;
		this.feedback_submitDate = feedback_submitDate;
		
	}

	public Long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(Long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getFeedback_description() {
		return feedback_description;
	}

	public void setFeedback_description(String feedback_description) {
		this.feedback_description = feedback_description;
	}

	public String getFeedback_submitDate() {
		return feedback_submitDate;
	}

	public void setFeedback_submitDate(String feedback_submitDate) {
		this.feedback_submitDate = feedback_submitDate;
	}

	public User getUser() {
		return fb;
	}

	public void setUser(User user) {
		this.fb = user;
	}

	public Feedback() {
		super();
	}


}
