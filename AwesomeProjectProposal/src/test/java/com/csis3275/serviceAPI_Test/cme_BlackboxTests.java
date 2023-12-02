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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class cme_BlackboxTests {

	private static FirefoxDriver driver;
	
	@BeforeAll
	public static void setUp() {
		//Set up browser
		System.setProperty("webdriver.gecko.driver", "A:\\Douglas\\csis3275\\geckodriver.exe");
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

}
