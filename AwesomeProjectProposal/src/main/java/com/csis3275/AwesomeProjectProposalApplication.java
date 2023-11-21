package com.csis3275;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.csis3275.model_api.Datum;
import com.csis3275.service_api.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.csis3275.model_db.User;
import com.csis3275.service_api.*;
import com.csis3275.service_db.UserService;
import com.csis3275.model_api.Datum;
import com.csis3275.service_api.*;
import com.fasterxml.jackson.databind.JsonNode;


@SpringBootApplication
public class AwesomeProjectProposalApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AwesomeProjectProposalApplication.class);
	static APIService apiService = new APIService();
	static List<Datum> listOfMatches = new ArrayList();
	static Datum matchOdds = new Datum();

	
	
	public static void main(String[] args) {
		log.info("In main method");

		SpringApplication.run(AwesomeProjectProposalApplication.class, args);
		try {
			//apiService.getHomeTeamHead2Head("274216");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Bean
	CommandLineRunner userDB(UserService repo)	{
		return (args) -> {
		repo.saveUser(new User("testusername", "test@email.com", "testpassword", "123456789"));
		repo.saveUser(new User("test2username", "test2@email.com", "test2password","098765234"));
		};
		
	}

}