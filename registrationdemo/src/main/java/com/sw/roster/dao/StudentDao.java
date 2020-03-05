package com.sw.roster.dao;

import java.util.List;

import com.sw.roster.model.Course;
import com.sw.roster.model.Student;

 
public interface StudentDao {

	Student findByEmail(String email);
	
	int registerCourseByCourseCode(String email, String code);
	
	List<Course> findRegisteredCourses(String email);

}
