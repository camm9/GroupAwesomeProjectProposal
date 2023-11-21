/**
 * 
 */
package com.csis3275.service_csv;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.model_db.User;
import com.csis3275.model_db.UserDataset;

/**
 * 
 */
class DataCSVServiceTest {
	DataCSVServiceImpl DCS = new DataCSVServiceImpl();
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
	void addEmptyUserDataset() {
		UserDataset UserData = new UserDataset();
		DCS.addUserDataset(UserData);
		assertEquals(1,DCS.getUserDataList().size());
	}
	
	@Test
	void addUserDatasetWithoutUser() {
		UserDataset UserData = new UserDataset();
		DCS.addUserDataset(UserData);
		assertEquals(1,DCS.getUserDataList().size());
	}
	
	@Test
	void addUserDatasetWithMatchID() {
		UserDataset UserData = new UserDataset();
		UserData.setMatchId("" + 1);
		DCS.addUserDataset(UserData);
		assertEquals(1,DCS.getUserDataList().size());
	}	
	
	@Test
	void addUserDatasetWithDate() {
		UserDataset UserData = new UserDataset();
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		DCS.addUserDataset(UserData);
		assertEquals(1,DCS.getUserDataList().size());
	}
	
	
	@Test
	void addUserDatasetWithEmptyNewUser() {
		UserDataset UserData = new UserDataset();
		User NewUser = new User();
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		DCS.addUserDataset(UserData);
		assertEquals(1,DCS.getUserDataList().size());
	}
	
	@Test
	void addUserDatasetWithNewUserWithToken() {
		UserDataset UserData = new UserDataset();
		User NewUser = new User("NewUser" + 1);
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		DCS.addUserDataset(UserData);
		assertEquals(1,DCS.getUserDataList().size());
	}
	
	@Test
	void addUserDatasetWithNewUserWithDetails() {
		UserDataset UserData = new UserDataset();
		User NewUser = new User();
		NewUser.setTokenUser("NewUser" + 1);
		NewUser.setEmail(1 + "@newuser.com");
		NewUser.setUserId(Long.valueOf(1));
		UserData.setUser(NewUser);
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		DCS.addUserDataset(UserData);
		assertEquals(1,DCS.getUserDataList().size());
	}
	
	@Test
	void ContentaddUserDatasetWithEmptyNewUser() {
		UserDataset UserData = new UserDataset();
		User NewUser = new User();
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		DCS.addUserDataset(UserData);
		List < UserDataset > User = DCS.getUserDataList();
		assertEquals(null,User.get(0));
	}
	
	@Test
	void ContentaddUserDatasetWithNewUserWithToken() {
		UserDataset UserData = new UserDataset();
		User NewUser = new User("NewUser" + 1);
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		DCS.addUserDataset(UserData);
		List < UserDataset > User = DCS.getUserDataList();
		assertEquals(null,User.get(0).toString());
	}
	
	@Test
	void ContentaddUserDatasetWithNewUserWithDetails() {
		UserDataset UserData = new UserDataset();
		User NewUser = new User();
		NewUser.setTokenUser("NewUser" + 1);
		NewUser.setEmail(1 + "@newuser.com");
		NewUser.setUserId(Long.valueOf(1));
		UserData.setUser(NewUser);
		UserData.setMatchId("" + 1);
		UserData.setDos(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		DCS.addUserDataset(UserData);
		List < UserDataset > User = DCS.getUserDataList();
		assertEquals(null,User.get(0).toString());
	}
	
}
