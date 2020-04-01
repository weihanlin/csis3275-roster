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
	public String create(@ModelAttribute("company") Company company, Model model) {
		int rst = 0;
		
		rst = companyDao.setUpCompany(company);
		
		//if rst > 0 => insert data to users_companies
		model.addAttribute("companies",companyDao.findAll());
		
		return "companies/list";
	}
	
	@GetMapping("/companies")
	public String showAllCompanies(Model model) {
		model.addAttribute("companies",companyDao.findAll());
		
		return "companies/list";
	}
	
	@PostMapping("/companies/{code}/delete")
	public String deleteCompany(@PathVariable("code") String code, final RedirectAttributes redirectAtt) {
		
		companyDao.deleteByCode(code);
		
		redirectAtt.addFlashAttribute("msg","success");
		return "redirect:/companies";
	}
	
	

}
