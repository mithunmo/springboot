package com.f9g4.web.forms;

public class ForgotPasswordForm {
	
	private String userName;
	
	private int secQ1id;
	private String secQ1Ans;
	
	private int secQ2id;
	private String secQ2Ans;
	
	public int getSecQ1id() {
		return secQ1id;
	}
	public void setSecQ1id(int secQ1id) {
		this.secQ1id = secQ1id;
	}
	public String getSecQ1Ans() {
		return secQ1Ans;
	}
	public void setSecQ1Ans(String secQ1Ans) {
		this.secQ1Ans = secQ1Ans;
	}
	public int getSecQ2id() {
		return secQ2id;
	}
	public void setSecQ2id(int secQ2id) {
		this.secQ2id = secQ2id;
	}
	public String getSecQ2Ans() {
		return secQ2Ans;
	}
	public void setSecQ2Ans(String secQ2Ans) {
		this.secQ2Ans = secQ2Ans;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
