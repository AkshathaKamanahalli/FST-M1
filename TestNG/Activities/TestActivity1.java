package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {

		//Declare class Objects
		
		WebDriver driver;
		WebDriverWait wait;
		
		@BeforeClass
		public void setUp() {
		//Initialize driver and wait
		driver= new FirefoxDriver();
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		//Open the page
		driver.get("https://training-support.net");
		}
		
		@Test(priority=1)
		public void homePageTest() {
			//Assertions
			Assert.assertEquals(driver.getTitle(), "Training Support");
		}
		
		@Test(priority=2)
		public void aboutPagetest() {
		//Find and click the About Us Link
			driver.findElement(By.linkText("About Us")).click();
	    //Assertion for page title
		Assert.assertEquals(driver.getTitle(), "About Training Support");
			
		}
			
		@AfterClass
		public void tearDown() {
			driver.quit();
			
		}
		
		

	}

