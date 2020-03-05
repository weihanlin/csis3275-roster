package com.sw.roster.dao;

import java.util.List;

import com.sw.roster.model.Course;
 
public interface CourseDao {

	Course findByCode(String name);
	 
	List<Course> findAll();

}
