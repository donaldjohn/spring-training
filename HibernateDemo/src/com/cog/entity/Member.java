package com.cog.entity;

public class Member {
	
	
	int id;
	String email;
	String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password="
				+ password + "]";
	}
	public Member(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public Member(){
		
	}
	
	

}
