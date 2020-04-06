package com.sw.roster.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sw.roster.dao.CompanyDao;
import com.sw.roster.dao.StudentDao;
import com.sw.roster.dao.UserDao;
import com.sw.roster.model.LoginInfo;
import com.sw.roster.model.Student;
import com.sw.roster.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CompanyDao companyDao;
	
	/**
	 * Create new signUpForm object for empty from
	 * 
	 * @return
	 */
	@ModelAttribute("loginInfo")
	public LoginInfo loginForm() {
		return new LoginInfo();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String login(HttpSession session) {
	    User user = (User) session.getAttribute("user");
	    if(user != null) {
	    	return "login-success";
	    }
	    return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		model.addAttribute("message", "Logout");
		session.invalidate();
	    return "login";
	}
	
	@PostMapping("/login") 
	public String login(@ModelAttribute("loginInfo") LoginInfo loginInfo, Model model){
		User user = userDao.findByID(loginInfo.getUserid());
		model.addAttribute("message", "Login Fail");

		if(user != null && user.getPassword().equals(loginInfo.getPassword())) {
			
			model.addAttribute("user",user);
			model.addAttribute("companies",companyDao.findCompanies(user.getUserID()));
			return "companies/list";
		}
		return "login";
	}
	
}
