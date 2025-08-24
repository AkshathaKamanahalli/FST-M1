package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity4 {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/lms/");
	}
	
	@Test
	public void SecoudPopularCourse() {
		//String text =driver.findElement(By.xpath("//h2[text()='Email Marketing Strategies']")).getText();
		String text = driver.findElement(By.xpath("//h3[contains(text(), \"Email\")]")).getText();
		Assert.assertEquals(text, "Email Marketing Strategies");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
