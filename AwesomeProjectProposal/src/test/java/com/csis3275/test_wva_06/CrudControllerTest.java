package com.csis3275.test_wva_06;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.csis3275.model_db.User;
import com.csis3275.service_db.IUserRepository;
import com.csis3275.service_db.UserService;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class CrudControllerTest {
	
	/* Need to inject MockMVC dependency for controller testing */
	@Autowired
	private MockMvc mvc;
	@Autowired
	private UserService userService;
	
	/**
	 * This test will check the UserController particularly listStudents() method to read user from DB and test attributes.
	 */
	
	@Test
	@DisplayName("Verify UserList Web Page")
	/**"It should display the list of users that are stored in the database."**/
	void TestMainPageCrud() throws Exception	{
							
				mvc.perform(MockMvcRequestBuilders
						.get("/admin")
						.accept(MediaType.TEXT_HTML))
						.andDo(print())
						.andExpect(model().hasNoErrors())
						.andExpect(model().attributeExists("userList"))
						.andExpect(MockMvcResultMatchers.view().name("/admin/index"))
						.andExpect(status().isOk());
		
	}
	
	
	/**
	 * This test will check the UserController particularly renderSaveMember() method to test the feature of save Admin users.
	 */
	
	@Test
	@DisplayName("Verify save users feature to the DB")
	/**"It should save a new user on the DB and redirect the Web page to the List of Users."**/
	void TestRenderSaveMember() throws Exception	{
			
		// sample user Administrator
		User newAdmin = new User("test3username", "test3@email.com", "test3password","778765234");
		
		mvc.perform(MockMvcRequestBuilders
				.post("/admin/saveadmin")
				.param("newAdmin", newAdmin.toString())
				.accept(MediaType.TEXT_HTML))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("redirect:/admin"));
		
	}
	
	
	/**
	 * This test will check the UserController particularly addStudentAdmin() method.
	 */
	
	@Test
	@DisplayName("Verify UserList Web Form")
	/**"It should display the form to create a New Administrator Account."**/
	void TestAddStudentAdmin() throws Exception	{
		
		mvc.perform(MockMvcRequestBuilders
				.get("/admin/add")
				.accept(MediaType.TEXT_HTML))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("/admin/addadmin"))
				.andExpect(status().isOk());
							
				
		
	}
	
	/**
	 * This test will check the UserController particularly deleteUser() method.
	 */
	
	@Test
	@DisplayName("Delete an Administrator")
	/**"It should delete a User Administrator from the DB and redirect the Web page to the List of Users."**/
	void TestDeleteUser() throws Exception	{
		
		// sample id variable for Administrator
		String id = "778765234";
		
		mvc.perform(MockMvcRequestBuilders
				.get("/users/delete")
				.param("deleteUser", id)
				.accept(MediaType.TEXT_HTML))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("redirect:/admin"));
		
	}
	
	@Test
	@DisplayName("Verify API Details WebPage ")
	/**"It should display the API details WEB PAGE without errors."**/
	void TestrenderApiDetailsAdmin() throws Exception	{
		
		mvc.perform(MockMvcRequestBuilders
				.get("/admin/api")
				.accept(MediaType.TEXT_HTML))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.view().name("/admin/apidetails"))
				.andExpect(status().isOk());		
		
	}

}
