package com.csis3275.service_api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

import com.csis3275.model_api.Datum;
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
	private String market = "market=classic" ;
	private String iso_date = "&iso_date=2023-10-01"; //user must choose this
	private String federation = "&federation=UEFA"; //user must choose this
//	public String finalUrl = initialUrl+market+iso_date+federation;
	
	private static final String rapidApiKey = "f3f0a7542fmsh81ac85922b3edc9p174165jsn99009b470c53";
	private static final String rapidApiHost = "football-prediction-api.p.rapidapi.com";

	ObjectMapper objectMapper = new ObjectMapper()
		.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	
	public void getAllPredictionDataForDate() {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(initialUrl + market + iso_date+federation))
					.header("X-RapidAPI-Key", rapidApiKey)
					.header("X-RapidAPI-Host", rapidApiHost)
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
			//See the print out of the data
			//System.out.println(response.body());
			
			//Map JSON to Predictions object
			//Configure objectMapper to ignore unknown properties
//			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			String JSONString = response.body();
			JsonNode data = objectMapper.readTree(JSONString).get("data");
			List<JsonNode> listOfNodes = data.findParents("home_team");
			
			for (int i = 0; i < listOfNodes.size(); i++) {
				String matchID = data.get(i).get("id").asText();
				String awayTeam = data.get(i).get("away_team").asText();
				System.out.println();
				String homeTeam = data.get(i).get("home_team").asText();
				System.out.println("Match ID: "+ matchID + " Home Team: "+ homeTeam + " vs. Away Team: "+ awayTeam);
			}
			
// I still like this idea of turning the JSON into a list of objects, while this code doesn't work I want to keep here for future reference and inspiration.			
//			Predictions[] predictions = objectMapper.readValue(String.valueOf(JSONString), new TypeReference<Predictions[]>() {
//			});
//			System.out.println(predictions[0].toString());
		
			
		}catch (Exception e) {
			System.out.println("something went wrong while getting value from API");
			e.printStackTrace();
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint API",
					e
					);
		}
	}
	
	public void getFederationList() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://football-prediction-api.p.rapidapi.com/api/v2/list-federations"))
				.header("X-RapidAPI-Key", "f3f0a7542fmsh81ac85922b3edc9p174165jsn99009b470c53")
				.header("X-RapidAPI-Host", "football-prediction-api.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
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
	
	

}
