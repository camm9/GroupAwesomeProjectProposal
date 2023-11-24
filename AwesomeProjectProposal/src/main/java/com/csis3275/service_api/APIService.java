package com.csis3275.service_api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.csis3275.model_api.Accuracy_Performance;
import com.csis3275.model_api.Data_Performance;
import com.csis3275.model_api.Datum;
import com.csis3275.model_api.HomeTeam_Head2Head;
import com.csis3275.model_api.Odds;
import com.csis3275.model_api.Overall_Head2Head;
import com.csis3275.model_api.Prediction_Performance;
import com.csis3275.model_api.Predictions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class APIService {
	private String initialUrl = "https://football-prediction-api.p.rapidapi.com/api/v2/predictions?";
	private String market = "market=classic";
	private String iso_date = "&iso_date=2023-10-01"; // user must choose this
	private String federation = "&federation=UEFA"; // user must choose this
//	public String finalUrl = initialUrl+market+iso_date+federation;

	private static final String rapidApiKey = "f3f0a7542fmsh81ac85922b3edc9p174165jsn99009b470c53";
	private static final String rapidApiHost = "football-prediction-api.p.rapidapi.com";

	ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public void getAllPredictionDataForDate() {
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(initialUrl + market + iso_date + federation))
					.header("X-RapidAPI-Key", rapidApiKey).header("X-RapidAPI-Host", rapidApiHost)
					.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			// See the print out of the data
			// System.out.println(response.body());

			// Map JSON to Predictions object
			// Configure objectMapper to ignore unknown properties

			String JSONString = response.body();
			JsonNode data = objectMapper.readTree(JSONString).get("data");
			List<JsonNode> listOfNodes = data.findParents("home_team");

			for (int i = 0; i < listOfNodes.size(); i++) {
				String matchID = data.get(i).get("id").asText();
				String awayTeam = data.get(i).get("away_team").asText();
				System.out.println();
				String homeTeam = data.get(i).get("home_team").asText();

				String prediction = data.get(i).get("prediction").asText();
				System.out.println("Match ID: "+ matchID + " Home Team: "+ homeTeam + " vs. Away Team: "+ awayTeam);
			}

		} catch (Exception e) {
			System.out.println("something went wrong while getting value from API");
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling endpoint API",
					e);
		}
	}

	public List<Datum> getAllMatchesForDate(String date) {
		List<Datum> matchList = new ArrayList();
		try {
			String init = "https://football-prediction-api.p.rapidapi.com/api/v2/predictions?market=classic&iso_date=";
			String fullURL = init + date;
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(fullURL))
					.header("X-RapidAPI-Key", rapidApiKey).header("X-RapidAPI-Host", rapidApiHost)
					.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String JSONString = response.body();
			JsonNode data = objectMapper.readTree(JSONString).get("data");
			// Get the number of matches expected in the day

			Datum matchInfo = objectMapper.readValue(JSONString, Datum.class);

			List<JsonNode> listOfNodes = data.findParents("home_team");

			// Add results for date to a List
			for (int i = 0; i < listOfNodes.size(); i++) {
				int matchID = data.get(i).get("id").asInt();
				String awayTeam = data.get(i).get("away_team").asText();
				String homeTeam = data.get(i).get("home_team").asText();
				String federation = data.get(i).get("federation").asText();
				String country = data.get(i).get("competition_cluster").asText();

				String prediction = data.get(i).get("prediction").asText();
				String status = data.get(i).get("status").asText();


				matchInfo = new Datum(matchID, homeTeam, awayTeam, federation, country, prediction, status);
				matchList.add(matchInfo);
			}

		} catch (Exception e) {
			System.out.println("something went wrong while getting value from API");
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling endpoint API",
					e);
		}

		// return list of matches
		return matchList;
	}

	public void getFederationList() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://football-prediction-api.p.rapidapi.com/api/v2/list-federations"))
				.header("X-RapidAPI-Key", "f3f0a7542fmsh81ac85922b3edc9p174165jsn99009b470c53")
				.header("X-RapidAPI-Host", "football-prediction-api.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String JSONString = response.body();
		System.out.println("Federations to Select From:");
		JsonNode federation;
		try {
			federation = objectMapper.readTree(JSONString).get("data");
			for (int i = 0; i < federation.size(); i++) {
				System.out.println(federation.get(i).asText());
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	Call matches by match id and return odds with prediction
	public Datum getMatchOdds(String matchID) {
		Datum matchInfo = null;

		try {
			String init = "https://football-prediction-api.p.rapidapi.com/api/v2/predictions/";
			String fullURL = init + matchID;
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(fullURL))
					.header("X-RapidAPI-Key", rapidApiKey).header("X-RapidAPI-Host", rapidApiHost)
					.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String JSONString = response.body();

			JsonNode data = objectMapper.readTree(JSONString);

			// sample match ID = 274216

			// Add results for matchID to an object of matchOdd and matchInfo
			for (int i = 0; i < 14; i++) {
				Integer idNum = Integer.valueOf(matchID);
				String awayTeam = data.findValue("away_team").asText();
				String homeTeam = data.findValue("home_team").asText();
				Double _1 = data.findValue("odds").findValue("1").asDouble();
				Double _2 = data.findValue("odds").findValue("2").asDouble();
				Double _12 = data.findValue("odds").findValue("12").asDouble();
				Double _x = data.findValue("odds").findValue("X").asDouble();
				Double x1 = data.findValue("odds").findValue("1X").asDouble();
				Double x2 = data.findValue("odds").findValue("X2").asDouble();
				String prediction = data.findValue("prediction").asText();

				Odds matchOdd = new Odds(_1, _2, _12, _x, x1, x2);
				// return match details in matchInfo
				matchInfo = new Datum(idNum, homeTeam, awayTeam, prediction, matchOdd);
			}

		} catch (Exception e) {
			System.out.println("something went wrong while getting value from API");
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling endpoint API",
					e);
		}
		return matchInfo;

	}

	// Get API prediction performance statistics
	public Accuracy_Performance getPrediction_Performance() {
		Accuracy_Performance accuracyData;

		try {

			String fullURL = "https://football-prediction-api.p.rapidapi.com/api/v2/performance-stats?market=classic";
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(fullURL))
					.header("X-RapidAPI-Key", rapidApiKey).header("X-RapidAPI-Host", rapidApiHost)
					.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String JSONString = response.body();

			JsonNode performanceData = objectMapper.readTree(JSONString);

			// Find win percentage over days
			Double performanceData_30DaysDouble = performanceData.findValue("accuracy").findValue("last_30_days")
					.asDouble();
			Double performanceData_14DaysDouble = performanceData.findValue("accuracy").findValue("last_14_days")
					.asDouble();
			Double performanceData_7DaysDouble = performanceData.findValue("accuracy").findValue("last_7_days")
					.asDouble();
			Double performanceData_YesterdayDouble = performanceData.findValue("accuracy").findValue("yesterday")
					.asDouble();

			accuracyData = new Accuracy_Performance(performanceData_30DaysDouble, performanceData_YesterdayDouble,
					performanceData_7DaysDouble, performanceData_14DaysDouble);

		} catch (Exception e) {
			System.out.println("something went wrong while getting value from API");
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling endpoint API",
					e);
		}

		return accuracyData;

	}

	// Get Overall Head to Head data up to 5 matches, required parameters = matchID
	public Overall_Head2Head getOverallHead2Head(String matchID) {
		// sample match ID = 274216

		
		Overall_Head2Head overallStats = null;
		
		try {

			String fullURL = "https://football-prediction-api.p.rapidapi.com/api/v2/head-to-head/" + matchID
					+ "?limit=5";
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(fullURL))
					.header("X-RapidAPI-Key", rapidApiKey).header("X-RapidAPI-Host", rapidApiHost)
					.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			String JSONString = response.body();

			JsonNode data = objectMapper.readTree(JSONString);
			
			Integer num_encounters = 5;
			Integer both_teams_scored = data.findValue("overall").get("both_teams_scored").asInt();
			Integer total_goals = data.findValue("overall").get("total_goals").asInt();
			Double avg_goals_per_match = data.findValue("overall").get("avg_goals_per_match").asDouble();
			
			//public Overall_Head2Head(Integer totalGoals,Integer bothTeamsScored,Double avgGoalsPerMatch, Integer numEncounters) 
			overallStats = new Overall_Head2Head(total_goals, both_teams_scored, avg_goals_per_match, num_encounters);
			
		} catch (Exception e) {
			System.out.println("something went wrong while getting value from API");
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling endpoint API",
					e);
		}
		return overallStats;
	}
	
	// Get Home Team Head to Head data up to 5 matches, required parameters = matchID
	// sample match ID = 274216
	public HomeTeam_Head2Head getHomeTeamHead2Head(String matchID) {
		
			
			HomeTeam_Head2Head homeTeam = null;
			
			try {

				String fullURL = "https://football-prediction-api.p.rapidapi.com/api/v2/head-to-head/" + matchID
						+ "?limit=5";
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(fullURL))
						.header("X-RapidAPI-Key", rapidApiKey).header("X-RapidAPI-Host", rapidApiHost)
						.method("GET", HttpRequest.BodyPublishers.noBody()).build();
				HttpResponse<String> response = HttpClient.newHttpClient().send(request,
						HttpResponse.BodyHandlers.ofString());

				String JSONString = response.body();

				JsonNode data = objectMapper.readTree(JSONString);
				
				String team_name = data.findValue("home_team").get("team_name").asText();
				Integer goalsScored = data.findValue("home_team").get("goals_scored").asInt();
				Integer goalsConceived = data.findValue("home_team").get("goals_conceived").asInt();
				Double avgGoalsScored = data.findValue("home_team").get("avg_goals_scored").asDouble();
				Double avgGoalsConceived = data.findValue("home_team").get("avg_goals_conceived").asDouble();
				Integer won = data.findValue("home_team").get("won").asInt();
				Integer lost = data.findValue("home_team").get("lost").asInt();
				Integer draw = data.findValue("home_team").get("draw").asInt();
				Integer cleanSheet = data.findValue("home_team").get("clean_sheet").asInt();
				Double avgBookieWinChance = data.findValue("home_team").get("avg_bookie_win_chance").asDouble();
				Double avgBookieDrawChance = data.findValue("home_team").get("avg_bookie_draw_chance").asDouble();
				Double avgBookieLoseChance = data.findValue("home_team").get("avg_bookie_lose_chance").asDouble();
				
				homeTeam = new HomeTeam_Head2Head(team_name, goalsScored, goalsConceived, avgGoalsScored, avgGoalsConceived, won, lost, draw, cleanSheet, avgBookieWinChance, avgBookieDrawChance, avgBookieLoseChance);
				
			} catch (Exception e) {
				System.out.println("something went wrong while getting value from API");
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while calling endpoint API",
						e);
			}
			return homeTeam;
		}
	


}
