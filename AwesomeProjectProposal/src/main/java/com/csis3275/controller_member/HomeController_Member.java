package com.csis3275.controller_member;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.csis3275.service_api.APIService;


@Controller
public class HomeController_Member {
	static APIService apiService = new APIService();
	
	@GetMapping("/member")
	public String renderHomeMmeber() {
		return "member/index";
	}
	
	@GetMapping("/member/mainstat")
	public String renderStatMember() {
		return "member/mainstat";
	}

	
	@PostMapping("/member/api_date")
	public String renderAPIDateMember(@RequestParam("date_p") String date_p, Model model) {
		model.addAttribute("matchList", apiService.getAllMatchesForDate(date_p));
		System.out.print(date_p);
		return "member/mainstat";
	}

}