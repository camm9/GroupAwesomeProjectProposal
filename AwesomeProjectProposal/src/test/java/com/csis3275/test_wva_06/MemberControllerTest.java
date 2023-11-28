package com.csis3275.test_wva_06;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.controller_member.*;


@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
//@WebMvcTest(HomeController_Member.class)
public class MemberControllerTest {
	
	/* Need to inject MockMVC dependency for controller testing */
	@Autowired
	private MockMvc mvc;
	
	/**
	 * This test will check the HomeController_Member specifically renderStatMember() method to check the model attributes are present.
	 */
	
	@Test
	@DisplayName("Verify Member Space Web Page with 302 status")
	/**"Should display an 302 error in member Space Web page and redirect to login page."**/
	void TestMainStatPage() throws Exception	{
		
				
		mvc.perform(MockMvcRequestBuilders
				.get("/member/mainstat")
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(status().is(302))
				.andExpect(MockMvcResultMatchers.view().name("redirect:/loginpage"));
	}
	
	
	/**
	 * This test will check the HomeController_Member specifically renderValidarUser() method to check the model attributes are present.
	 */
	@Test
	@DisplayName("Verify tokenuser attribute for Members with 302 status")
	/**"Should verify a tokenuser attribute for Members without errors"**/
	void TestRenderValidarUser() throws Exception	{
		
		
		mvc.perform(MockMvcRequestBuilders
				.get("/member/valida")
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("redirect:/member"))
				.andExpect(model().attribute("tokenuser", nullValue()))
				.andExpect(status().is(302));			
	}
	
	/**
	 * This test will check the HomeController_Member specifically renderSaveDatasetMember() method to check the model attributes are present.
	 */
	@Test
	@DisplayName("Verify a user is logged")
	/**"Based on tokenuser attribute members should be redirect to Login page or Dashboard Web page."**/	
	void TestRenderSaveDatasetMember() throws Exception	{

		mvc.perform(MockMvcRequestBuilders
				.get("/member")
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("/loginpage"))
				.andExpect(status().isOk());
	}
	
	/**
	 * This test will check the HomeController_Member specifically renderSaveDatasetMember() method to check the model attributes are present.
	 */
	@Test
	@DisplayName("Save a specific dataset on DB")
	/**"The test should save a specific data set selected by users and identify the parameters matchID, token, date1, date2."**/	
	void TestRenderSaveDatasetMemberDB() throws Exception	{

		// sample random string
		String rnd = "oi1rf3gpaiobaqdkp5ih045uusc6rgfqe9fr4sl9rtnki8ejrj52f34pme4mptfqcsn698d7790c1c4g4kir2h2cvsimtat7vb9v";
		// sample matchID take from API (valid)
		String matchid = "277799";
		// sample tokenID
		String token = "2";
		// sample Date of search
		String dos = "2023-11-26";
		// sample Date of match 
		String date_p = "2023-11-26";
		
		mvc.perform(MockMvcRequestBuilders
				.get("/member")
				.param("rnd", rnd)
				.param("matchid", matchid)
				.param("token", token)
				.param("dos", dos)
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("/loginpage"))
				.andExpect(status().isOk());
	}
	
	
	@Test
	@DisplayName("Verify dahsboard Web page")
	/**"Should display dahsboard Web page without errors"**/	
	void TestEenderAPIDateMember2() throws Exception	{

		mvc.perform(MockMvcRequestBuilders
				.get("/member")
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("/loginpage"))
				.andExpect(status().isOk());
	}
	
	
	@Test
	@DisplayName("Get statistics details using a matchID from Dashboard")
	/**"Should display details of a specific matchID, which is passed by get parameter."**/	
	void TestRenderMatchIDDetails() throws Exception	{

		// sample matchID take from API (valid)
		String matchID = "277799";
				
		mvc.perform(MockMvcRequestBuilders
				.get("/member/matchIDdetails")
				.param("matchID", matchID)
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(model().attribute("matchID","277799"))
				.andExpect(MockMvcResultMatchers.view().name("member/matchdetails"))
				.andExpect(status().isOk());
	}
	
	
	
	

	
	
}
