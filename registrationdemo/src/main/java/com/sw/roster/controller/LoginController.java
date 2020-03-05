package com.sw.roster.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sw.roster.dao.StudentDao;
import com.sw.roster.model.LoginInfo;
import com.sw.roster.model.Student;

@Controller
@SessionAttributes("student")
public class LoginController {
	
	@Autowired
	StudentDao studentDao;
	
	
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
	    Student student = (Student) session.getAttribute("student");
	    if(student != null) {
	    	return "login-success";
	    }
	    return "login";
	}

	@PostMapping("/login") 
	public String login(@ModelAttribute("loginInfo") LoginInfo loginInfo, Model model){
		Student student = studentDao.findByEmail(loginInfo.getEmail());
		model.addAttribute("message", "Login Fail");

		if(student != null && student.getPassword().equals(loginInfo.getPassword())) {
			model.addAttribute("student", student);
			model.addAttribute("message", "Login Successful");
			return "login-success";
		}
		return "login";
	}
	
}
