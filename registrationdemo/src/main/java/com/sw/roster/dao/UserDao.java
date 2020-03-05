package com.sw.roster.dao;

import java.util.List;

import com.sw.roster.model.User;

 
public interface UserDao {

	User findByName(String name);
	 
	List<User> findAll();

}
