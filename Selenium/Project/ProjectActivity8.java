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

public class ProjectActivity8 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void ContactAdmin() {
		driver.findElement(By.linkText("Contact")).click();
		driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Akshatha Kamanahalli");
		driver.findElement(By.id("wpforms-8-field_1")).sendKeys("1234@gmail.com");
		driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Learn New course");
		driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Approve my new course");
		driver.findElement(By.id("wpforms-submit-8")).click();
		String submissionMess = driver
				.findElement(By.xpath("//p[text()='Thanks for contacting us! We will be in touch with you shortly.']"))
				.getText();
		System.out.println(submissionMess);
		Assert.assertEquals(submissionMess, "Thanks for contacting us! We will be in touch with you shortly.");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
