package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		 // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get(" https://training-support.net/webelements/alerts");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
       // Find the button to open a SIMPLE alert and click it.
        driver.findElement(By.id("simple")).click();
       
        //Switch the focus from the main window to the Alert box and get the text in it and print it.
        Alert simpleAlert = driver.switchTo().alert();
        //driver.switchTo().alert().accept();
        System.out.println(simpleAlert.getText());
        //System.out.println("Text in alert: " + alertText);
       // Close the alert once with OK.
        simpleAlert.accept();
        //Close the browser.
        driver.quit();
        
        
	}

}
