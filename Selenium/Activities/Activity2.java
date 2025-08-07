package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		
		//Get Title of the page
	    System.out.println("Page Title is:" + driver.getTitle());
	    //Find the username field and enter admin
	    driver.findElement(By.id("username")).sendKeys("admin");
	    //Find the password field and enter password
	    driver.findElement(By.id("password")).sendKeys("password");
	    //Find and click on Submit button
	    driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
	    //Verify the successful Login Message
	    String message= driver.findElement(By.cssSelector("h1.text-emerald-500")).getText();
	    System.out.println("Login Success Message:"+ message);
	    
	    //Close the Browser
	    driver.quit();
	    
		
	}

}
