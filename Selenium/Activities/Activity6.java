package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/dynamic-controls");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        //Find the checkbox input element.
       WebElement checkbox =driver.findElement(By.id("checkbox"));
        
        //Check if the checkbox is selected and print the result.
        checkbox.click();
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
        
        //Click the checkbox to select it.
        checkbox.click();
        
        //Check if the checkbox is selected again and print the result.
        System.out.println("Checkbox is selected: " + checkbox.isSelected());

    //Close the browser.
        driver.quit();

	}

}
