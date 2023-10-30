package com.csis3275;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.csis3275.model_db.User;
import com.csis3275.service_api.*;
import com.csis3275.service_db.UserService;

@SpringBootApplication
public class AwesomeProjectProposalApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AwesomeProjectProposalApplication.class);
	static APIService apiService = new APIService();
	
	
	public static void main(String[] args) {
		log.info("In main method");
		SpringApplication.run(AwesomeProjectProposalApplication.class, args);
		try {
//			apiService.getAllPredictionDataForDate();
//			apiService.getFederationList();
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
