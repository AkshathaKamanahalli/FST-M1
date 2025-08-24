package project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity7 {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/lms/");
	}
		
	@Test
	public void getCountOfCoursesTest(){
		driver.findElement(By.linkText("All Courses")).click();
		List<WebElement> courses = driver.findElements(By.cssSelector(".ld-course-list-items .ld_course_grid"));
		Assert.assertEquals(courses.size(), 3);
		System.out.println(courses);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
