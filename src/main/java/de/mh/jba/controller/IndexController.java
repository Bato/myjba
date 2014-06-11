package de.mh.jba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.mh.jba.service.ItemService;

@Controller
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		
		log.info("IN IndexController.index" );
		
		model.addAttribute("items", itemService.getItems());
		
		/* returns template 'index' from general.xml		 */
		return "index";
		
		
	}
	
}
