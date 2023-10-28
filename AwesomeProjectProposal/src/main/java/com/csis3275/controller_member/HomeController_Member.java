package com.csis3275.controller_member;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController_Member {
	
	@GetMapping("/member")
	public String renderHomeMmeber() {
		return "member/index";
	}
	
	@GetMapping("/member/mainstat")
	public String renderStatMember() {
		return "member/mainstat";
	}

	
	@PostMapping("/member/api_date")
	public String renderAPIDateMember(@RequestParam("date_p") String date_p) {
		System.out.print(date_p);
		return "member/mainstat";
	}

}
