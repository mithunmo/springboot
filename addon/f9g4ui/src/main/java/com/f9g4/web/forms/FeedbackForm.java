package com.f9g4.web.forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class FeedbackForm {

	@NotEmpty(message="{require.firstName}")
	private String firstname;
	
	@NotEmpty(message="{require.lastName}")
	private String lastname;
	
	private String phone;
	
	@NotEmpty(message="{require.email}")
	@Email(message="{require.email.format}")
	private String email;
	
	@NotEmpty(message="{require.feedback}")
	private String feedback;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	@Override
	public String toString() {
		return "FeedbackForm [firstname=" + firstname + ", lastname="
				+ lastname + ", phone=" + phone + ", email=" + email
				+ ", feedback=" + feedback + "]";
	}
}
