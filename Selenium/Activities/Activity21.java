package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {
		 // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        //Create a Wait Object
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        // Open the page
        driver.get("https://training-support.net/webelements/tabs");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        
        //Find and click button to open new tab
        driver.findElement(By.xpath("//button[text()='Open A New Tab']")).click();
        //Print the handel of the current tab
        System.out.println("Current tab Handel:"+driver.getWindowHandle());
        //Print the handels of all the open tabs
        System.out.println("Current tab Handel:"+driver.getWindowHandles());
        
     // Switch focus to the latest tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        
      //Print the handel of the current tab
        System.out.println("Current tab Handel:"+driver.getWindowHandle());
       //Print the title and message from the new page
        System.out.println("Title of the new tab:"+ driver.getTitle());
        System.out.println("Message on the new tab:"+driver.findElement(By.cssSelector("h2.mt-5")).getText());
     // Find and click the button on page to open another tab
        driver.findElement(By.xpath("//button[contains(text(), 'Another One')]")).click();
        driver.quit();

	}

}
