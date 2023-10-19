package com.csis3275.controller_member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController_Member {
	
	@GetMapping("/member")
	public String renderHomeMmeber() {
		return "member/index";
	}

}
