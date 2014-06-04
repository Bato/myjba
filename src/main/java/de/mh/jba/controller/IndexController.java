package de.mh.jba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/index")
	public String index() {
		
		log.info("IN IndexController.index" );
		/* returns template 'index' from general.xml		 */
		return "index";
		
		
	}
	
}
