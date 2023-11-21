package com.csis3275.controller_navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Navigation {
	
	@GetMapping("/")
	public String renderHome() {
		return "home";
	}
	
	@GetMapping("/loginpage")
	public String renderLogin() {
		return "loginpage";
	}

	@GetMapping("/test")
	public String renderTest() {
		return "test";
	}
	
	@GetMapping("/testAPICharts")
	public String renderTestAPICharts() {
		return "testAPICharts";
	}
}
