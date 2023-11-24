/**
 * 
 */
package com.csis3275.model_API_Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

/**
 * This test will confirm that getters and setters are working correctly
 * for the API objects
 */
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
class Test_APIObjects {
	/* Need to inject MockMVC dependency for controller testing */
	@Autowired
	private MockMvc mvc;
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
