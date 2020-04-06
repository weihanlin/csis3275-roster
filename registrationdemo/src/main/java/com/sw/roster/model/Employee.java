package com.sw.roster.model;

import java.util.List;

public class Employee {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String login_id;
	private String password;
	List<String> availability;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getAvailability() {
		return availability;
	}
	public void setAvailability(List<String> availability) {
		this.availability = availability;
	}

	
	

}
