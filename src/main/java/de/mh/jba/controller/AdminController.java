package de.mh.jba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import de.mh.jba.service.UserService;

@Controller
@RequestMapping("/users") 
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping 
	public String users(Model model) {
		
		log.info("IN AdminController.users" );
		log.info("userService.findAll()=" + userService.findAll().size());
		model.addAttribute("users", userService.findAll());		
		
		/* returns template 'user' from general.xml		 */
		return "users";
	}
		
	@RequestMapping("/{id}")
	public String detail(Model model, @PathVariable int id)  {
		log.info("IN AdminController.detail" );
		model.addAttribute("user", userService.findOneWithBlogs(id));
		
		/* returns template 'user-detail' from general.xml		 */
		return "user-detail";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable int id) {
		log.info("IN AdminController.removeUser" );
		userService.delete(id);
		return "redirect:/users.html";
	}	
	
}
