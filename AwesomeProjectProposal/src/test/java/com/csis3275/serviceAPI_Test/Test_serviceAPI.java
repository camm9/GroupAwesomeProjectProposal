package com.csis3275.serviceAPI_Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import com.csis3275.model_api.Datum;
import com.csis3275.model_api.Odds;
import com.csis3275.model_api.Overall_Head2Head;
import com.csis3275.service_api.APIService;

/**
 * This test for service the methods within APIService deliver the expected API
 * responses
 * 
 */
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
class Test_serviceAPI {

	APIService apiService = new APIService();

	/* Need to inject MockMVC dependency for controller testing */
	@Autowired
	private MockMvc mvc;

	@Test
	@DisplayName("Should Create List of Matches")
	public void shouldGetListOfMatches() {
		String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
		List<Datum> matchList = apiService.getAllMatchesForDate(dateTime);

		// that API call is not null
		assertNotNull(matchList);

		// check that it is a List type
		assertTrue(matchList instanceof List);

		// check that the list is not empty (every day should have matches)
		assertFalse(matchList.isEmpty());

		// check that each item in list is a Datum object
		for (Datum obj : matchList) {
			assertTrue(obj instanceof Datum);
		}
	}


	@Test
	@DisplayName("Should Create a Datum object with MatchOdds")
	public void shouldGetMatchOdds() {
		// sample matchID take from API 274216
		String matchID = "274216";

		Datum testData = apiService.getMatchOdds(matchID);

		// that API call is not null
		assertNotNull(testData);

		// check that it is a Datum type
		assertTrue(testData instanceof Datum);
		
		//check that Odds field is found in testData
		Odds oddsField = testData.getOdds();
		
		assertNotNull(oddsField);
		
		assertEquals(Odds.class, oddsField.getType());

	}
	
	@Test
	@DisplayName("Should Return API error - non-existent MatchID")
	public void shouldMatchIDNotExist() {
		String fakeMatchID = "123";
		
		//Should throw a ResponseStatusException
		assertThrows(ResponseStatusException.class, () ->{
			apiService.getOverallHead2Head(fakeMatchID);
		});
	}

}
