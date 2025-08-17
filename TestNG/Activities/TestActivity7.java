package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity7 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize driver
		driver = new FirefoxDriver();

		// Initialize wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page
		driver.get("https://training-support.net/webelements/login-form");

	}

	@Test(priority = 1)
	public void pageTitleTest() {
		// page title assertaion
		Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");
	}

	@DataProvider(name = "InvalidCreds")
	public Object[][] creds() {
		return new Object[][] { { "admin", "WrongPassword" }, { "WrongAdmin", "password" }, };
	}

	@Test(priority = 2, dataProvider = "InvalidCreds")
	public void loginTest(String username, String password) {

		// Find the username ,password and submit elements
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

		// Clear the input fields

		usernameField.clear();
		passwordField.clear();

		// Enter the credentials and click Log in

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);

		// click on submit button
		submitButton.click();

		// Assertions
		// Assert login message

		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();
		Assert.assertEquals(message, "Invalid credentials");

	}

	@AfterClass
	public void tearDown() {

		// Close the browser
		driver.quit();

	}

}
