package com.f9g4.webapp.domain;

public class User {
	

	    private Integer id;
	 
	
	    private String firstname;
	 
	   
	    private String lastname;
	 
	  
	    private String email;
	 
	 
	    private String telephone;
	 
	    public String getEmail() {
	        return email;
	    }
	    public String getTelephone() {
	        return telephone;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }
	    public String getFirstname() {
	        return firstname;
	    }
	    public String getLastname() {
	        return lastname;
	    }
	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }
	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }
	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }

}
