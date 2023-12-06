package com.csis3275.controller_member;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.csis3275.model_db.User;
import com.csis3275.model_db.UserDataset;
import com.csis3275.service_api.APIService;
import com.csis3275.service_db.UserDatasetService;
import com.csis3275.service_db.UserService;

import java.util.List;
import java.util.*;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.persistence.Entity;

@Controller
public class HomeController_Member {

	@Autowired
	private UserDatasetService userDatasetService;
	@Autowired
	private UserService userData;

	
	private APIService apiService;
	
	Boolean session_var = false;

	Random random = new Random();
	String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());

	private String date_p_s;
	private String token_s;
	private String date_today;
	private int sizeAPICurrentDay;
	private int sizePreferedMID;

	@GetMapping("/member/test")
	public String renderHomeMmeber() {
		return "member/index";
	}

	@GetMapping("/member/mainstat")
	public String renderStatMember(Model model) {

		List<String> dateIdUser = new ArrayList<>(Arrays.asList());
		List<String> totalDateIdUser = new ArrayList<>(Arrays.asList());
		List<String> occurrencesIdUser = new ArrayList<>(Arrays.asList());

		if (token_s == null) {
			return "redirect:/loginpage";
		} else {
			this.date_p_s = null;
			this.date_today = dateTime;

			if (sizeAPICurrentDay == 0) {
				sizeAPICurrentDay = apiService.getAllMatchesForDate(dateTime).size();
			}

			sizePreferedMID = userDatasetService.findDataSetbyToken(Long.parseLong(token_s)).size();

			if (sizePreferedMID > 0) {
				for (int i = 0; i < sizePreferedMID; i++) {

					totalDateIdUser.add(userDatasetService.findDataSetbyToken(Long.parseLong(token_s)).get(i).getDos());

					if (!dateIdUser
							.contains(userDatasetService.findDataSetbyToken(Long.parseLong(token_s)).get(i).getDos())) {
						dateIdUser.add(userDatasetService.findDataSetbyToken(Long.parseLong(token_s)).get(i).getDos());

					}

				}

			}

			long x;
			for (int j = 0; j < dateIdUser.size(); j++) {
				x = appearances(dateIdUser.get(j), totalDateIdUser);
				occurrencesIdUser.add(String.valueOf(x));
			}

			model.addAttribute("matchListSize", sizeAPICurrentDay);
			model.addAttribute("preferedDataSet", userDatasetService.findDataSetbyToken(Long.parseLong(token_s)));
			model.addAttribute("dateTime", dateTime);
			model.addAttribute("dateArray", dateIdUser.stream().collect(Collectors.joining("\",\"", "[\"", "\"]")));
			model.addAttribute("occurrences", occurrencesIdUser.stream().collect(Collectors.joining(",", "[", "]")));

			return "member/mainstat";
		}

	}

	private static long appearances(String datum, List<String> nums) {
		return nums.stream().filter(i -> i.equals(datum)).count();
	}

	@GetMapping("/member/valida")
	public String renderValidarUser(Model model) {

		this.token_s = "2";
		model.addAttribute("tokenuser", token_s);
		session_var = true;

		return "redirect:/member";
	}

	@GetMapping("/logout")
	public String renderLogoutUser() {
		session_var = false;
		return "/loginpage";
	}

	@GetMapping("/member/matchdetails")
	public String renderMatchDetails(Model model) {
		return "member/matchdetails";
	}
	
	
	@GetMapping("/member/matchIDdetails")
	public String renderMatchIDDetails(@RequestParam("matchID") String matchID, Model model) {
		model.addAttribute("matchID", matchID);
		return "member/matchdetails";
	}

	@PostMapping("/member")
	public String renderAPIDateMember(@RequestParam("date_p") String date_p, @RequestParam("token") String token,
			Model model) {

		List<String> matchIdUser = new ArrayList<>(Arrays.asList("000000"));

		this.date_p_s = date_p;
		this.token_s = token;

		model.addAttribute("matchList", apiService.getAllMatchesForDate(date_p));
		model.addAttribute("matchListSize", apiService.getAllMatchesForDate(date_p).size());

		sizePreferedMID = userDatasetService.findDataSetbyToken(Long.parseLong(token_s)).size();

		if (sizePreferedMID > 0) {
			for (int i = 0; i < sizePreferedMID; i++) {
				matchIdUser.add(userDatasetService.findDataSetbyToken(Long.parseLong(token_s)).get(i).getMatchId());
			}

		}

		model.addAttribute("preferedDataSet", matchIdUser);

		model.addAttribute("tokenuser", token_s);
		model.addAttribute("dateTime", dateTime);
		model.addAttribute("date_p", date_p_s);
		model.addAttribute("rnd", new BigInteger(500, random).toString(32));
		return "member/index";
	}

	@GetMapping("/member")
	public String renderAPIDateMember2(Model model) {

		if (date_p_s == null) {
			model.addAttribute("matchList", "");
			model.addAttribute("matchListSize", 0);
			model.addAttribute("date_p", "");
		} else {

			model.addAttribute("matchList", apiService.getAllMatchesForDate(date_p_s));
			model.addAttribute("matchListSize", apiService.getAllMatchesForDate(date_p_s).size());
			model.addAttribute("date_p", date_p_s);
		}

		if (userDatasetService.readUserDataset().size() > 0) {
			List<String> matchesId = new ArrayList<>();

			for (int i = 0; i < userDatasetService.readUserDataset().size(); i++) {
				matchesId.add(userDatasetService.readUserDataset().get(i).getMatchId());
			}

			model.addAttribute("userdDataset", matchesId);
		}

		model.addAttribute("tokenuser", token_s);
		model.addAttribute("dateTime", dateTime);

		model.addAttribute("rnd", new BigInteger(500, random).toString(32));

		if (token_s == null) {
			return "/loginpage";
		} else {
			return "member/index";
		}

	}

	@GetMapping("/member/savedataset")
	public String renderSaveDatasetMember(@RequestParam("rnd") String rnd, @RequestParam("matchid") String matchid,
			@RequestParam("tok") String token, @RequestParam("dos") String dos, @RequestParam("dose") String date_p) {
		User user1 = userData.findUser(Long.parseLong(token));
		userDatasetService.saveUserDataset(new UserDataset(matchid, date_p, user1));

		this.date_p_s = date_p;
		this.token_s = token;

		return "redirect:/member";
	}

//Render matchodds page
	@GetMapping("/member/matchodds")
	public String renderMatchOdds(Model model) {
		// returns object of accuracy_Performance API predictions of last 30 days
		DecimalFormat df = new DecimalFormat("#%");
		model.addAttribute("accuracyData_30Days", df.format(apiService.getPrediction_Performance().getLast30Days()));
		model.addAttribute("accuracyData_14Days", df.format(apiService.getPrediction_Performance().getLast14Days()));
		model.addAttribute("accuracyData_7Days", df.format(apiService.getPrediction_Performance().getLast7Days()));
		model.addAttribute("accuracyData_Yesterday", df.format(apiService.getPrediction_Performance().getYesterday()));
		return "member/matchodds";
	}

	// Prints match odds to matchodds page
	@PostMapping("/member/api_searchByMatchID")
	public String renderAPIMatchDetails(Model model, @RequestParam(value = "searchByMatchID") String searchByMatchID) {
		model.addAttribute("matchIDDetails", apiService.getMatchOdds(searchByMatchID));
		model.addAttribute("getOdd_1", apiService.getMatchOdds(searchByMatchID).getOdds().get1());
		model.addAttribute("getOdd_2", apiService.getMatchOdds(searchByMatchID).getOdds().get2());
		model.addAttribute("getOdd_12", apiService.getMatchOdds(searchByMatchID).getOdds().get12());
		model.addAttribute("getOdd_X", apiService.getMatchOdds(searchByMatchID).getOdds().getX());
		model.addAttribute("getOdd_1X", apiService.getMatchOdds(searchByMatchID).getOdds().get1x());
		model.addAttribute("getOdd_X2", apiService.getMatchOdds(searchByMatchID).getOdds().getX2());
		
		DecimalFormat df = new DecimalFormat("#%");
		model.addAttribute("accuracyData_30Days", df.format(apiService.getPrediction_Performance().getLast30Days()));
		model.addAttribute("accuracyData_14Days", df.format(apiService.getPrediction_Performance().getLast14Days()));
		model.addAttribute("accuracyData_7Days", df.format(apiService.getPrediction_Performance().getLast7Days()));
		model.addAttribute("accuracyData_Yesterday", df.format(apiService.getPrediction_Performance().getYesterday()));
		return "member/matchodds";
	}

	// Post matchID to get populated charts of matchdetails page
	@PostMapping("/member/api_searchMatchDetailsByID")
	public String renderMatchDetails(@RequestParam(value = "matchDetailsByID") String matchDetailsByID, Model model) {
		model.addAttribute("overallHead2Head", apiService.getOverallHead2Head(matchDetailsByID));
		return "member/matchdetails";
	}

}