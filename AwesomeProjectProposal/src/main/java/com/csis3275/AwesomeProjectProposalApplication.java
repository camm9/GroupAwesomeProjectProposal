package com.csis3275;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.csis3275.model_api.Datum;
import com.csis3275.service_api.*;
import com.fasterxml.jackson.databind.JsonNode;

@SpringBootApplication
public class AwesomeProjectProposalApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AwesomeProjectProposalApplication.class);
	static APIService apiService = new APIService();
	static List<Datum> listOfMatches = new ArrayList();
	static List<Datum> matchOdds = new ArrayList();
	
	
	public static void main(String[] args) {
		log.info("In main method");
		SpringApplication.run(AwesomeProjectProposalApplication.class, args);
		try {
			listOfMatches = apiService.getAllMatchesForDate("2023-10-28");
			matchOdds = apiService.getMatchOdds("273761");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
