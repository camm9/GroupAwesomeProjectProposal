/**
 * 
 */
package com.csis3275.model_API_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.csis3275.model_api.Datum;
import com.csis3275.model_api.Overall_Head2Head;
import com.csis3275.service_api.APIService;

/**
 * This test will confirm that getters and setters are working correctly
 * for the API-based objects.
 * 
 * Requirements for object testing in Sprint 2: change object state and verify change
 * 
 * Because we have a number of objects due to the nested nature of our JSON parsing, we are only testing
 * the most critical objects.
 * 
 * We can test the validity of our objects getters and setters by changing the parameters of our API call. 
 * If we call the API and use it's information to fill an object, we can then change the variables of the object by simply
 * changing the API parameter.
 */
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
class Test_APIObjects {
	/* Need to inject MockMVC dependency for controller testing */
	@Autowired
	private MockMvc mvc;
	
	APIService apiService = new APIService();
	
	@Test
	@DisplayName("Should Get Correct Home Team")
	public void shouldGetExpectedHomeTeam() {
		// sample matchID take from RapidAPI website, home team should be West Ham
		// sample matchID = 274216
		String expectedHomeTeam = "West Ham";
		String matchID = "274216";
		Datum matchSample = apiService.getMatchOdds(matchID);
		
		String resultHomeTeam = matchSample.getHomeTeam();
		
		//check that West Ham is the expected result
		assertEquals(expectedHomeTeam, resultHomeTeam);
		
		// now let's change the matchID and see if the Home Team name updates
		// new sample ID = 274222, home team = Brest
		expectedHomeTeam = "Brest";
		matchID = "274222";
		matchSample = apiService.getMatchOdds(matchID);
		
		resultHomeTeam = matchSample.getHomeTeam();
		
		// Check that Brest is the expected result
		assertEquals(expectedHomeTeam, resultHomeTeam);	
	}
	
//	Overall_Head2Head getOverallHead2Head(String matchID)
	
	@Test
	@DisplayName("Should Get Total Goals")
	public void shouldGetExpectedTotalGoals() {
		// sample matchID take from RapidAPI website, 274216
		// Expected total_goals = 8
		String matchID = "274216";
		Overall_Head2Head overallStats_Test  = apiService.getOverallHead2Head(matchID);
		
		Integer expectedTotalGoals = 8;
		Integer resultTotalGoals = overallStats_Test.getTotalGoals();
		
		// Check results match expectations
		assertEquals(expectedTotalGoals, resultTotalGoals);
		
		
		// sample matchID take from RapidAPI website, new matchID = 274222
		// Expected total_goals = 17
		matchID = "274222";
		overallStats_Test  = apiService.getOverallHead2Head(matchID);
		
		expectedTotalGoals = 17;
		resultTotalGoals = overallStats_Test.getTotalGoals();
		
		// Check results match expectations
		assertEquals(expectedTotalGoals, resultTotalGoals);
	}


}
