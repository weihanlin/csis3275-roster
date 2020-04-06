package com.sw.roster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sw.roster.dao.UserDao;
import com.sw.roster.model.LoginInfo;
import com.sw.roster.model.User;

@Controller
public class SignUpController {

	@Autowired
	UserDao userDao;
	
	
	/**
	 * Create new signUpForm object for empty from
	 * 
	 * @return
	 */
	@ModelAttribute("user")
	public User setSignUpForm() {
		return new User();
	}
	
	@ModelAttribute("loginInfo")
	public LoginInfo loginForm() {
		return new LoginInfo();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/showSignUpForm")
	public String showForm() {
		return "signup-form";
	}

	/**
	 * Save User sign up form
	 * 
	 * @param signUpForm
	 * @param model
	 * @return
	 */
	@PostMapping("/saveSignUpForm")
	public String saveUser(@ModelAttribute("user") User user, Model model) {

		userDao.addUser(user);
				
		model.addAttribute("message", "User SignUp successfully.");

		return "login";
	}
}
