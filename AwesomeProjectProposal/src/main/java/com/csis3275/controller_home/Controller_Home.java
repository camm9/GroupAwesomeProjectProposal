package com.csis3275.controller_home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Home {
	
	@GetMapping("/")
	public String renderHome() {
		return "home";
	}

}
