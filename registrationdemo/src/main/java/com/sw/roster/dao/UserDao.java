package com.sw.roster.dao;

import java.util.List;

import com.sw.roster.model.User;

 
public interface UserDao {

	User findByID(int id);
	 
	List<User> findAll();
	
	int addUser(User user);

}
