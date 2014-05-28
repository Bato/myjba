package de.mh.jba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.mh.jba.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private UserService userService;
	
	

	@RequestMapping("/users") 
	public String users(Model model) {
		
		log.info("IN UserController.users" );
		log.info("userService.findAll()=" + userService.findAll().size());
		model.addAttribute("users", userService.findAll());		
		return "users";
	}
}
