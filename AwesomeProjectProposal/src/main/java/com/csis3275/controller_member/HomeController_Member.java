package com.csis3275.controller_member;

import java.text.DecimalFormat;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model_api.Accuracy_Performance;
import com.csis3275.service_api.APIService;


@Controller
public class HomeController_Member {
	static APIService apiService = new APIService();
	
	@GetMapping("/member")
	public String renderHomeMmeber(Model model) {
		//returns object of accuracy_Performance API predictions of last 30 days 
		DecimalFormat df = new DecimalFormat("#%");
		model.addAttribute("accuracyData", df.format(apiService.getPrediction_Performance().getLast30Days()));
		return "member/index";
	}
	
	@GetMapping("/member/mainstat")
	public String renderStatMember() {
		return "member/mainstat";
	}
	
	@GetMapping("/member/matchdetails")
	public String renderMatchDetails() {
		return "member/matchdetails";
	}


	
	@PostMapping("/member/api_date")
	public String renderAPIDateMember(@RequestParam("date_p") String date_p, Model model) {
		model.addAttribute("matchList", apiService.getAllMatchesForDate(date_p));
//		System.out.print(date_p);
		return "member/mainstat";
	}

	//Prints match odds to mainstat page
	@PostMapping("/member/api_searchByMatchID")
	public String renderAPIMatchDetails(Model model,@RequestParam(value="searchByMatchID") String searchByMatchID) {
//		System.out.print(searchByMatchID);
		model.addAttribute("matchIDDetails", apiService.getMatchOdds(searchByMatchID));
		model.addAttribute("getOdd_1", apiService.getMatchOdds(searchByMatchID).getOdds().get1());
		model.addAttribute("getOdd_2", apiService.getMatchOdds(searchByMatchID).getOdds().get2());
		model.addAttribute("getOdd_12", apiService.getMatchOdds(searchByMatchID).getOdds().get12());
		model.addAttribute("getOdd_X", apiService.getMatchOdds(searchByMatchID).getOdds().getX());
		model.addAttribute("getOdd_1X", apiService.getMatchOdds(searchByMatchID).getOdds().get1x());
		model.addAttribute("getOdd_X2", apiService.getMatchOdds(searchByMatchID).getOdds().getX2());
		return "member/mainstat";
	}
	
	//Prints match odds to matchdetails page
	@PostMapping("/member/api_searchByMatchID2")
	public String renderAPIMatchDetails2(Model model,@RequestParam(value="searchByMatchID") String searchByMatchID) {
		model.addAttribute("matchIDDetails", apiService.getMatchOdds(searchByMatchID));
		model.addAttribute("getOdd_1", apiService.getMatchOdds(searchByMatchID).getOdds().get1());
		model.addAttribute("getOdd_2", apiService.getMatchOdds(searchByMatchID).getOdds().get2());
		model.addAttribute("getOdd_12", apiService.getMatchOdds(searchByMatchID).getOdds().get12());
		model.addAttribute("getOdd_X", apiService.getMatchOdds(searchByMatchID).getOdds().getX());
		model.addAttribute("getOdd_1X", apiService.getMatchOdds(searchByMatchID).getOdds().get1x());
		model.addAttribute("getOdd_X2", apiService.getMatchOdds(searchByMatchID).getOdds().getX2());
		return "member/matchdetails";
	}

}
