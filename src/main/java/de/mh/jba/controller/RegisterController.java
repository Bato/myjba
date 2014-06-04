package de.mh.jba.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import de.mh.jba.entity.User;
import de.mh.jba.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
	
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
	public User constructUser() {
		return new User();
	}
	
	@RequestMapping
	public String showRegister(){
		return "user-register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		log.info("IN RegisterController.doRegister" );
		
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
}
