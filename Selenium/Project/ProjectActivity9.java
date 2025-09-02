package project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity9 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/lms/");
	}
	
	@Test
	public void completeALessonTest() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.linkText("All Courses")).click();
		List<WebElement> links = driver.findElements(By.cssSelector("a.btn.btn-primary"));
		for (WebElement link : links) {
			String href = link.getAttribute("href");
		    if (href.contains("social-media-marketing")) {
		    	link.click();
		        break;
		    }
		}
		List<WebElement> courses = driver.findElements(By.cssSelector("a.ld-item-name"));
		for (WebElement course : courses) {
			String href = course.getAttribute("href");
			if(href.contains("developing-strategy")) {
				course.click();
				break;
			}
		}
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Developing Strategy – Alchemy LMS");
		List<WebElement> markCompleteButtons = driver.findElements(
			    By.cssSelector("input[value='Mark Complete']")
			);

			if (!markCompleteButtons.isEmpty()) {
			    // Button found, click it
			    markCompleteButtons.get(0).click();
			    System.out.println("Clicked 'Mark Complete' button.");
			} else {
			    // Button not found, skip
			    System.out.println("'Mark Complete' button not found, skipping.");
			}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}