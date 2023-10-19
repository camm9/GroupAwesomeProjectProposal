package com.csis3275.service_api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class APIService {
	private String initialUrl = "https://football-prediction-api.p.rapidapi.com/api/v2/predictions?";
	private String market = "market=classic" ;
	private String iso_date = "&iso_date=2023-10-01";
	private String federation = "&federation=UEFA";
	public String finalUrl = initialUrl+market+iso_date+federation;
	
	private static final String rapidApiKey = "f3f0a7542fmsh81ac85922b3edc9p174165jsn99009b470c53";
	private static final String rapidApiHost = "football-prediction-api.p.rapidapi.com";

	ObjectMapper objectMapper = new ObjectMapper();
	
	public void getAllPredictionData() {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(finalUrl))
					.header("X-RapidAPI-Key", rapidApiKey)
					.header("X-RapidAPI-Host", rapidApiHost)
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
			//See the print out of the data
			System.out.println(response.body());
			
			//Map JSON to Predictions object
			Predictions[] predictions = objectMapper.readValue(String.valueOf(response), new TypeReference<Predictions[]>() {
			});
			System.out.println(predictions[0].toString());
		
			
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

}
