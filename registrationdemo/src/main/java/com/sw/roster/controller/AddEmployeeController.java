package com.sw.roster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@PostMapping("/companies/{code}/addEmployee")
	public String create(@ModelAttribute("employee") Employee employee, @PathVariable("code") String code, Model model) {
		
		int rst = employeeDao.addEmployee(employee);
		
		employee.setId(employeeDao.getEmployeeID(employee));
		
		if(rst > 0)
			employeeDao.addEmployee(employee, code);
		
		model.addAttribute("code",code);
		model.addAttribute("employees", employeeDao.findByCode(code));
		
		return "employeeList";
	}
	
	@PostMapping("/companies/{code}/manage")
	public String manageEmployee(@PathVariable("code") String code, Model model) {
		
		model.addAttribute("code",code);
		model.addAttribute("employees", employeeDao.findByCode(code));
		
		return "employeeList";
	}
	
	@PostMapping("/companies/{code}/addEmp")
	public String addEmployee(@PathVariable("code") String code, Model model) {
		
		model.addAttribute("code",code);
		model.addAttribute("employees", employeeDao.findByCode(code));
		
		return "addEmployee";
	}
	
	
	
	
	
}
