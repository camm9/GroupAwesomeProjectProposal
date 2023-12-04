package com.csis3275.serviceAPI_Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

public class cme_BlackboxTests {
	
	public static String driverPath = "A:\\Douglas\\csis3275\\geckodriver.exe";

	private static FirefoxDriver driver;
	// setting up browser to run tests
	@BeforeAll
	public static void setUp() {
		//Set up browser
		System.setProperty("webdriver.gecko.driver", driverPath);
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		options.setImplicitWaitTimeout(Duration.ofSeconds(10));
		driver = new FirefoxDriver(options);
	}
	
	@AfterAll
	public static void tearDown()	{
		//Quit the browser
		driver.quit();
	}
	
	//this tests the user's ability to search for match stats by entering a matchID 
	@Test
	@DisplayName("User searches for match stats")
	  public void searchMatchStats() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().maximize();
	    driver.findElement(By.cssSelector(".ml-2")).click();
	    driver.findElement(By.linkText("GitHub")).click();
	    driver.findElement(By.linkText("Match Details")).click();
	    driver.findElement(By.id("matchDetailsByIDValue")).click();
	    driver.findElement(By.id("matchDetailsByIDValue")).sendKeys("279290");
	    driver.findElement(By.id("matchDetailsByID_button")).click();
	    driver.quit();
	  }
	
	//this tests the user's ability to search for match odds by entering a matchID 
	@Test
	@DisplayName("User searches for match odds")
	  public void searchMatchOdds() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().maximize();
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.linkText("GitHub")).click();
	    driver.findElement(By.cssSelector(".nav-item:nth-child(6) span")).click();
	    driver.findElement(By.name("searchByMatchID")).click();
	    driver.findElement(By.name("searchByMatchID")).sendKeys("279290");
	    driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
	  }
	
	//this tests the user's ability to retrieve for match stats by clicking a matchID hyperlink on matchOdds page 
	@Test
	@DisplayName("User clicks matchID on match odds page")
	  public void viewStatsviaOddsPage() {
	    driver.get("http://localhost:8080/");
	    driver.manage().window().maximize();
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.linkText("GitHub")).click();
	    driver.findElement(By.cssSelector(".nav-item:nth-child(6) span")).click();
	    {
	      WebElement element = driver.findElement(By.linkText("Match Odds"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.name("searchByMatchID")).click();
	    driver.findElement(By.name("searchByMatchID")).sendKeys("273762");
	    driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
	    driver.findElement(By.linkText("273762")).click();
	}

}
