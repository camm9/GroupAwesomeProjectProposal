package com.csis3275.test_wva_06;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BBSaveDatasetTest {
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
	 * This Black Box test (Functional Box Testing) will check the saved feature for and specific dataset.
	 */
  @Test
  @DisplayName("Verify Saving Dataset function")
  /**"It should disabled the save button, change its text as saved and change its color to CODE-WARNING (#ffc107)."**/
  public void BVAsaveDatasetTest() {
    driver.get("http://localhost:8080/member");
    driver.manage().window().setSize(new Dimension(1054, 784));
    driver.findElement(By.name("date_p")).click();
    driver.findElement(By.cssSelector(".today:nth-child(2)")).click();
    driver.findElement(By.name("btnsavedataset279700")).click();
    {
      WebElement element = driver.findElement(By.name("btnvalue279700"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    assertEquals(driver.findElement(By.name("btnvalue279700")).getText(),"Saved");
  }
}
