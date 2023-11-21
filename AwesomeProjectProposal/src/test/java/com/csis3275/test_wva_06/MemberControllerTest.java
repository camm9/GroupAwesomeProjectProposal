package com.csis3275.test_wva_06;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;

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
	void TestMainStatPage() throws Exception	{
		mvc.perform(MockMvcRequestBuilders
				.get("/member/mainstat")
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(model().attributeExists("matchListSize"))
				.andExpect(model().attributeExists("preferedDataSet"))
				.andExpect(model().attributeExists("dateTime"))
				.andExpect(model().attributeExists("dateArray"))
				.andExpect(model().attributeExists("occurrences"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("member/mainstat"));
	}
	
	
	/**
	 * This test will check the HomeController_Member specifically renderValidarUser() method to check the model attributes are present.
	 */
	@Test
	void TestRenderValidarUser() throws Exception	{
		
		
		mvc.perform(MockMvcRequestBuilders
				.get("/member/valida")
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("redirect:/member"))
				.andExpect(model().attribute("tokenuser", nullValue()))
				.andExpect(status().isOk());
				
	}
	
	
	
	@Test
	void TestRenderSaveDatasetMember() throws Exception	{

		mvc.perform(MockMvcRequestBuilders
				.get("/member")
				.accept(MediaType.TEXT_HTML)) //From springframework.http
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("/loginpage"))
				.andExpect(status().isOk());
	}
	
	
	


	
	
	
}
