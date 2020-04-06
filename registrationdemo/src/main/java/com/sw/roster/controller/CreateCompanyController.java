package com.sw.roster.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sw.roster.dao.CompanyDao;
import com.sw.roster.model.Company;
import com.sw.roster.model.User;

@Controller
public class CreateCompanyController {
	
	@Autowired
	CompanyDao companyDao;
	
	@ModelAttribute("company")
	public Company company() {
		return new Company();
	}
	
	@GetMapping("/createCompany")
	public String showForm() {

		return "createCompany";
	}
	
	@PostMapping("/createCompany")
	public String create(HttpSession session, @ModelAttribute("company") Company company, Model model) {
	    User user = (User) session.getAttribute("user");
	    int rst = 0;
	    if(user != null) {
	    	rst = companyDao.setUpCompany(company);
	    	if(rst > 0)
	    		companyDao.setUpCompany(company,user.getUserID());
	    	
	    	model.addAttribute("companies",companyDao.findCompanies(user.getUserID()));
	    	
	    	return "companies/list";
	    }
		
		return "redirect:/login";
	}
	
	@GetMapping("/companies")
	public String showAllCompanies(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");

	    if(user != null) {	    	
	    	model.addAttribute("companies",companyDao.findCompanies(user.getUserID()));
	    	
	    	return "companies/list";
	    }
		
		return "redirect:/login";
		
	}
	
	@PostMapping("/companies/{code}/delete")
	public String deleteCompany(@PathVariable("code") String code, final RedirectAttributes redirectAtt) {
		
		companyDao.deleteByCode(code);
		
		redirectAtt.addFlashAttribute("msg","success");
		return "redirect:/companies";
	}
	
	

}
