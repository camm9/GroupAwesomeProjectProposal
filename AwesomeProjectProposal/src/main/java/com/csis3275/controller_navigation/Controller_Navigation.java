package com.csis3275.controller_navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Navigation {
	
	@GetMapping("/")
	public String renderHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String renderLogin() {
		return "login";
	}

}
