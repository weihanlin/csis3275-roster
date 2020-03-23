package com.sw.roster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sw.roster.dao.EmployeeDao;
import com.sw.roster.model.Employee;

@Controller
public class AddEmployeeController {

	@Autowired
	EmployeeDao employeeDao;
	
	@ModelAttribute("employee")
	public Employee employee() { return new Employee(); }
	
	@GetMapping("/addEmployee")
	public String showForm() { return "addEmployee"; }
	
	@PostMapping("/addEmployee")
	public String create(@ModelAttribute("employee") Employee employee, Model model) {
		employeeDao.addEmployee(employee);
		
		return "new-employee";
	}
	
}
