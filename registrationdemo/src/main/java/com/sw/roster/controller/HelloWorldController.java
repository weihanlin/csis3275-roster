package com.sw.roster.controller;

import java.time.LocalDateTime; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.sw.roster.model.HelloWorld;
import com.sw.roster.model.Message;



@Controller
public class HelloWorldController {

	
	@RequestMapping("/helloworld")
	public String handler(Model model) {

		HelloWorld helloWorld = new HelloWorld();
		List<Message> strings = new ArrayList<Message>();
		for(int i = 0; i < 5; i++) {
			String tmpStr = "String" + i;
			Message msg = new Message();
			msg.setContent(tmpStr);
			strings.add(msg);
		}
		
		helloWorld.setMessages(strings);
		helloWorld.setDateTime(LocalDateTime.now().toString());
		model.addAttribute("temp", helloWorld);
		return "helloworld";
	}
}
