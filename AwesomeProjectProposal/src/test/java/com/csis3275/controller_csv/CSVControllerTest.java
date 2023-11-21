/**
 * 
 */
package com.csis3275.controller_csv;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.csis3275.model_db.User;
import com.csis3275.model_db.UserDataset;
import com.csis3275.service_db.UserDatasetService;

/**
 * 
 */
class CSVControllerTest {
	CSVController CC = new CSVController();
	UserDatasetService UDS = new UserDatasetService();
	User NewUser = new User();
	UserDataset UserData = new UserDataset();
	
	/* Need to inject MockMVC dependency for controller testing */
	@Autowired
	private MockMvc mvc;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	/*
	 * Test for case where dummy data is triggered
	 */
	public void NoUserStat () throws Exception {
		mvc.perform( MockMvcRequestBuilders
				.post("/member/export-to-csv/")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk());

	}
	
	@Test
	/*
	 * Test for case where Error Stack data is produced
	 */
	public void ErrorStackTrigger () throws Exception {
		mvc.perform( MockMvcRequestBuilders
				.post("/member/export-to-csv/")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk());

	}
	
	@Test
	/*
	 * Test for case where User Stat is produced
	 */
	public void EmptyUserStatTrigger () throws Exception {
		UDS.saveUserDataset(new UserDataset());
		mvc.perform( MockMvcRequestBuilders
				.post("/member/export-to-csv/")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk());

	}
	
	/*
	 * Test for case where User Stat is produced
	 */
	public void TokenUserStatTrigger () throws Exception {
		UDS.saveUserDataset(UserData);
		mvc.perform( MockMvcRequestBuilders
				.post("/member/export-to-csv/")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk());

	}
	
	/*
	 * Test for case where Full User Dataset is produced
	 */
	public void FullUserStatTrigger () throws Exception {
		UDS.saveUserDataset(UserData);
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		UserData.setUser(NewUser);
		mvc.perform( MockMvcRequestBuilders
				.post("/member/export-to-csv/")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk());

	}
	
	/*
	 * Test for case where Full User Dataset with empty UserUser Stat is produced
	 */
	public void EmptyUserUserStatTrigger () throws Exception {
		UDS.saveUserDataset(UserData);
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		NewUser.setTokenUser("NewUser" + 1);
		NewUser.setEmail(1 + "@newuser.com");
		NewUser.setUserId(Long.valueOf(1));
		UserData.setUser(NewUser);
		mvc.perform( MockMvcRequestBuilders
				.post("/member/export-to-csv/")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk());
	}
}
