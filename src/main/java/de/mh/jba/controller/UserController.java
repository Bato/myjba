package de.mh.jba.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.mh.jba.entity.Blog;
import de.mh.jba.service.BlogService;
import de.mh.jba.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;
		
	/**
	 * 29: Twitter Bootstrap modal
	 * form:form commandName="blog" 
	 * 
	 * 
	 * @return
	 */
	@ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}	
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		log.info("IN UserController.account" );
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithBlogs(name) );
		/* return template 'account' from general.xml		 */
		return "account";
	}

	/**
	 *  form:form commandName="blog"  
	 *  
	 * @param blog
	 * @param principal
	 * @return
	 */
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String doAddBlog(Model model, 
			@Valid @ModelAttribute("blog") Blog blog,
			BindingResult result, Principal principal) {
		
		if (result.hasErrors()) {
		  return account(model, principal);	
		}
		
		String name = principal.getName();
		blogService.save(blog, name);
		return "redirect:/account.html";
	}	
	
	@RequestMapping("/blog/remove/{id}")
	public String removeBlog(@PathVariable int id) {
		log.info("IN UserController.removeBlog id=" + id );
		Blog blog = blogService.findOne(id);
		blogService.delete(blog);
		return "redirect:/account.html";
	}
	
}
