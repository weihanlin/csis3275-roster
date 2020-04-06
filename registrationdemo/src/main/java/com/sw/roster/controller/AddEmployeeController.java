package com.sw.roster.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	@PostMapping("/employees/{id}/addEmployee")
	public String updateEmployee(@PathVariable("id") int id, @ModelAttribute("employee") Employee employee, Model model) { 
		
		Employee o_employee = employeeDao.findById(id);
		
		o_employee.setFirst_name(employee.getFirst_name());
		o_employee.setLast_name(employee.getLast_name());
		o_employee.setEmail(employee.getEmail());
		o_employee.setLogin_id(employee.getLogin_id());
		if(!employee.getPassword().equals(""))
			o_employee.setPassword(employee.getPassword());
		o_employee.setAvailability(employee.getAvailability());
		o_employee.setPosition(employee.getPosition());
		
		employeeDao.update(o_employee);
		
		String code = employeeDao.findCode(o_employee);
		
		model.addAttribute("code",code);
		model.addAttribute("employees", employeeDao.findByCode(code));

		return "employeeList"; 
	}
	
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
	
	@GetMapping("/companies/{code}/manage")
	public String manageEmployee(@PathVariable("code") String code, Model model) {
		
		model.addAttribute("code",code);
		model.addAttribute("employees", employeeDao.findByCode(code));
		
		return "employeeList";
	}
	
	@PostMapping("/companies/{code}/addEmp")
	public String addEmployee(@PathVariable("code") String code, Model model) {
		
		model.addAttribute("code",code);
		populateDefaultModel(model);
		
		return "addEmployee";
	}
	
	
	@PostMapping("/employees/{id}/delete/{code}")
	public String deleteEmployee(@PathVariable("id") int id,@PathVariable("code") String code, final RedirectAttributes redirectAtt) {
		
		employeeDao.deleteById(id);
		
		redirectAtt.addFlashAttribute("msg","success");
		
		return "redirect:/companies/" + code + "/manage";
	}
	
	@GetMapping("/employees/{id}/query")
	public String queryEmployee(@PathVariable("id") int id, Model model) {
		
		Employee employee = employeeDao.findById(id);
		
		model.addAttribute("employee", employee);
		populateDefaultModel(model);
		
		return "addEmployee";
	}
	
	private void populateDefaultModel(Model model) {

		List<String> availablekList = new ArrayList<String>();
		availablekList.add("Mon");
		availablekList.add("Tue");
		availablekList.add("Wed");
		availablekList.add("Thr");
		availablekList.add("Fri");
		availablekList.add("Sat");
		availablekList.add("Sun");
		model.addAttribute("availableList", availablekList);
		
		Map<String, String> position = new LinkedHashMap<String, String>();
		position.put("HR", "Human Resource");
		position.put("PM", "Project Management");
		position.put("RD", "Research Development");
		position.put("QA", "Quality Assurance");
		model.addAttribute("positionList", position);
		
	}
	
}
