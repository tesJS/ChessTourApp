package com.example.ChessTourApp.model;

public class CheckUser {
	private User user;
	private boolean userPasswordMatches;
	public CheckUser(User user, boolean userPasswordMatches) {
		super();
		this.user = user;
		this.userPasswordMatches = userPasswordMatches;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isuserPasswordMatches() {
		return userPasswordMatches;
	}
	public void setuserPasswordMatches(boolean userPasswordMatches) {
		this.userPasswordMatches = userPasswordMatches;
	}
	
	

}
