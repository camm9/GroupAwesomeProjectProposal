package com.csis3275.controller_navigation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.csis3275.model_api.Datum;
import com.csis3275.service_api.APIService;

@Controller
public class Controller_Navigation {
	static APIService apiService = new APIService();
	
	@GetMapping("/")
	public String renderHome(Model model) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List matchList = apiService.getAllMatchesForDate(LocalDate.now().format(formatter));
		Datum sampleMatch = (Datum) matchList.get(0);
		Integer sampleMatchId = sampleMatch.getId();
		
		model.addAttribute("matchList", matchList.subList(0, 3));
		model.addAttribute("SampleMatchId", sampleMatchId);
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
