package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

	public static void main(String[] args) throws InterruptedException {
		 // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get(" https://training-support.net/webelements/alerts");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        //Find the button to open a Prompt alert and click it.
        driver.findElement(By.id("prompt")).click();
        //Switch the focus from the main window to the Alert box and get the text in it and print it.
        Alert promptAlert =driver.switchTo().alert();
     // Print the text in the alert
        String alertText = promptAlert.getText();
        System.out.println("Text in alert: " + alertText);
        // Type into the alert
        promptAlert.sendKeys("Awesome!");
        Thread.sleep(5000);

        // Close the alert by clicking OK
        promptAlert.accept();
        // Print the message
        System.out.println(driver.findElement(By.id("result")).getText());
     // Close the browser
        driver.quit();
        

	}

}
