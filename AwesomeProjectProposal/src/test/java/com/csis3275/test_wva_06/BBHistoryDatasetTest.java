package com.csis3275.test_wva_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BBHistoryDatasetTest {
	
	 private static WebDriver driver;
	  private static Map<String, Object> vars;
	  static JavascriptExecutor js;
	  
	  @BeforeAll
	  public static void setUp() {
	    driver = new FirefoxDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  
	  @AfterAll
	  public static void tearDown() {
	    driver.quit();
	  }
	  
	  
	  /**
		 * This Black Box test (Functional Box Testing) will check the retrieving data feature for the stored datasets.
		 */
	  @Test
	  @DisplayName("Verify Retrieving Dataset function")
	  /**"It should add as minimum one new paired tag <div> with dataset (1 or 2) name where also the saved dataset will be display."**/
	  public void BBHistoryDatasetTest() {
	    driver.get("http://localhost:8080/member/mainstat");
	    driver.manage().window().setSize(new Dimension(1054, 784));
	    driver.findElement(By.name("yourstat")).click();
	    {
		      WebElement element = driver.findElement(By.name("dataset1"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();
		    }
	    assertEquals(driver.findElement(By.name("dataset1")).getText(),"Dataset # 1");
	  }
	  
	  
	  /**
		 * This Black Box test (Functional Box Testing) will check an empty dataset entity.
		 */
	  @Test
	  @DisplayName("Verify Empty Datasets")
	  /**"It should a new paired tag <div> with the name preferedDataSetVerify which is empty and it is used only for testing."**/
	  public void BBHistoryEmptyDatasetTest() {
	    driver.get("http://localhost:8080/member/mainstat");
	    driver.manage().window().setSize(new Dimension(1054, 784));
	    driver.findElement(By.name("yourstat")).click();
	    {
		      WebElement element = driver.findElement(By.name("preferedDataSetVerify"));
		      Actions builder = new Actions(driver);
		      builder.moveToElement(element).perform();
		    }
	    assertEquals(driver.findElement(By.name("preferedDataSetVerify")).isDisplayed(),true);
	  }

}
