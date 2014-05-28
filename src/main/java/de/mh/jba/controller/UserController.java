package de.mh.jba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.mh.jba.entity.User;
import de.mh.jba.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	/**
	 * The way how to bind from Spring controller to JSP File
	 * form:form commandName="user" 
	 * 
	 * 
	 * @return
	 */
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}
	
	@RequestMapping("/users") 
	public String users(Model model) {
		
		log.info("IN UserController.users" );
		log.info("userService.findAll()=" + userService.findAll().size());
		model.addAttribute("users", userService.findAll());		
		return "users";
	}
		
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id)  {
		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegister(){
		return "user-register";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "user-register";
	}
}
