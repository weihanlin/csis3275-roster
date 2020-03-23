package com.sw.roster.dao;

import com.sw.roster.model.Employee;

public interface EmployeeDao {
	Employee findById(int id);

	int addEmployee(Employee employee);
	
	void deleteById(int id);
	
}
