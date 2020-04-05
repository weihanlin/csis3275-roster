package com.sw.roster.dao;

import java.util.List;

import com.sw.roster.model.Employee;

public interface EmployeeDao {
	Employee findById(int id);

	int addEmployee(Employee employee);
	
	int addEmployee(Employee employee, String code);
	
	void deleteById(int id);
	
	List<Employee> findByCode(String code);
	
	int getEmployeeID(Employee employee);
	
}
