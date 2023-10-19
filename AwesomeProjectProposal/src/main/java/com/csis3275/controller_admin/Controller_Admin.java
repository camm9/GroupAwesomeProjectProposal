package com.csis3275.controller_admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Admin {
	
	@GetMapping("/admin")
	public String renderHomeMmeber() {
		return "admin/index";
	}

}
