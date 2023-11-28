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

	/*
	 * Checks if getAllMatchesForDate("yyyy-MM-dd") returns API results with
	 * List<Datum> of matches and their details
	 */
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

	/* Checks getMatchOdds successfully get's betting odds from API of a matchID */
	@Test
	@DisplayName("Should Create a Datum object with MatchOdds")
	public void shouldGetMatchOdds() {
		// sample matchID take from API
		String matchID = "274216";

		Datum testData = apiService.getMatchOdds(matchID);

		// that API call is not null
		assertNotNull(testData);

		// check that it is a Datum type
		assertTrue(testData instanceof Datum);

		// check that Odds field is found in testData
		Odds oddsField = testData.getOdds();

		assertNotNull(oddsField);

		assertEquals(Odds.class, oddsField.getType());

	}

	/*
	 * Checks that expected errors are thrown when non-existent MatchID is entered
	 * into getOverallHead2Head(matchID)
	 */
	@Test
	@DisplayName("Should Return API error - non-existent MatchID")
	public void shouldMatchIDNotExist() {
		String fakeMatchID = "123";

		// Should throw a ResponseStatusException
		assertThrows(ResponseStatusException.class, () -> {
			apiService.getOverallHead2Head(fakeMatchID);
		});
	}

	/*
	 * Boundary Value Analysis testing for API functions. Because API uses it's own
	 * randomized assigned id value (matchID), there are not 'true' minimal and
	 * maximal values to be entered. We will test by manipulating a valid matchID to
	 * minimal and maximal values, these naturally become more 'out of bound'
	 * testing than the regular min and max testing of BVA
	 */
	@Test
	@DisplayName("BVA Testing API")
	public void BVATest_API() {
		// sample matchID take from API (valid)
		String matchID = "274216";
		Datum testData = apiService.getMatchOdds(matchID);
		// that API call is not null
		assertNotNull(testData);

		// check that it is a Datum type
		assertTrue(testData instanceof Datum);

		// check that Odds field is found in testData
		Odds oddsField = testData.getOdds();

		
		// minimal & out of bounds value
		String min_MatchID = "-274216";

		// Should throw a ResponseStatusException
		assertThrows(ResponseStatusException.class, () -> {
			Datum testData_Min = apiService.getMatchOdds(min_MatchID);
		});

		
		// maximal & out of bounds value
		String max_MatchID = "274216000";
		// Should throw a ResponseStatusException
		assertThrows(ResponseStatusException.class, () -> {
			Datum testData_Max = apiService.getMatchOdds(max_MatchID);
		});

		
		// random out of bounds value
		String random_MatchID = "alksfj!";
		// Should throw a ResponseStatusException
		assertThrows(ResponseStatusException.class, () -> {
			Datum testData_Random = apiService.getMatchOdds(random_MatchID);
		});

	}

}
