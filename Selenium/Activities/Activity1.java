package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// create a driver object
		WebDriver driver=new FirefoxDriver(); //ChromeDriver or EdgeDriver
		//Open the page
		driver.get("https://training-support.net/");
		//verify using the page title
		System.out.println("Page Title is:" + driver.getTitle());
		
		//Interactions
		//driver.findElement(By.cssSelector("a.card")).click();
		//driver.findElement(By.linkText("About Us")).click();
		//Return Type of Find element is WebElement
		WebElement aboutLink=driver.findElement(By.linkText("About Us"));
		aboutLink.click();
		
		
		//Print the title of new page
		System.out.println("New Page Title is:" + driver.getTitle());
		
		//close the browser
	    driver.quit(); 

	}

}
