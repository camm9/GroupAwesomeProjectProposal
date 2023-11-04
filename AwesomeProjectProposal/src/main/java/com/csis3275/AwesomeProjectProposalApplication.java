package com.csis3275;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


<<<<<<< HEAD
import com.csis3275.model_api.Datum;
import com.csis3275.service_api.*;
import com.fasterxml.jackson.databind.JsonNode;
=======
>>>>>>> 79fea08 (Rebase: trying to fix rebase issues)
import com.csis3275.model_db.User;
import com.csis3275.service_api.*;
import com.csis3275.service_db.UserService;

<<<<<<< HEAD
=======
import com.csis3275.model_api.Match;
import com.csis3275.service_api.*;
import com.fasterxml.jackson.databind.JsonNode;
>>>>>>> 79fea08 (Rebase: trying to fix rebase issues)

@SpringBootApplication
public class AwesomeProjectProposalApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AwesomeProjectProposalApplication.class);
	static APIService apiService = new APIService();
<<<<<<< HEAD
	static List<Datum> listOfMatches = new ArrayList();
	static Datum matchOdds = new Datum();
=======
	static List<Match> listOfMatches = new ArrayList();
>>>>>>> 79fea08 (Rebase: trying to fix rebase issues)
	
	
	public static void main(String[] args) {
		log.info("In main method");
		SpringApplication.run(AwesomeProjectProposalApplication.class, args);
		try {

//			listOfMatches = apiService.getAllMatchesForDate("2023-10-28");
			// to access each match and a chosen variable in listOfMatches
//			for(int i=0; i < listOfMatches.size(); i++) {
//				System.out.println(listOfMatches.get(i).getCompetitionCluster());
//			}
			
			//to get a set of odds for the selected matchID
//			matchOdds = apiService.getMatchOdds("274216");
			
//			apiService.getAllPredictionDataForDate();
//			apiService.getFederationList();

<<<<<<< HEAD
=======
			listOfMatches = apiService.getAllMatchesForDate("2023-10-28");

>>>>>>> 79fea08 (Rebase: trying to fix rebase issues)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Bean
	CommandLineRunner userDB(UserService repo)	{
		return (args) -> {
		repo.saveUser(new User("testusername", "test@email.com", "testpassword"));
		repo.saveUser(new User("test2username", "test2@email.com", "test2password"));
		};
		
	}

}
