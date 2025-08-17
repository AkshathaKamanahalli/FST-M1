package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		 // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get(" https://training-support.net/webelements/alerts");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        //Find the button to open a CONFIRM alert and click it.
        driver.findElement(By.id("confirmation")).click();
        //Switch the focus from the main window to the Alert box and get the text in it and print it.
        Alert confirmAlert =driver.switchTo().alert();
        String alerttext=confirmAlert.getText();
        System.out.println("Text in alert: " + alerttext);
        
        //Can also close the alert by clicking Cancel
        //confirmAlert.dismiss();
        
        //Close the alert once with Ok and again with Cancel.
        confirmAlert.accept();
        System.out.println(driver.findElement(By.id("result")).getText());
        
        //Close the browser.
        driver.quit();
	}

}
