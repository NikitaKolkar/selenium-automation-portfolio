package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorsDemo1 {

	public static void main(String[] args) throws InterruptedException {
		//initiate the webdriver
		WebDriver driver = new ChromeDriver();
		//maximize the browser window
		driver.manage().window().maximize();
		
		//Open AUT
		driver.get("https://awesomeqa.com/ui/index.php?route=account/login");	
		
		//find element by ID
		driver.findElement(By.id("input-email")).sendKeys("nikitatest@gmail.com");
		
		//find element by Name
		driver.findElement(By.name("password")).sendKeys("Admin123");
		
		//find element by LinkText
		//driver.findElement(By.partialLinkText("Forgotten Password")).isDisplayed();
		
		 //find element by PartialLinkText
		boolean isForgetPassVisible = driver.findElement(By.partialLinkText("Forgotten Passwo")).isDisplayed();
		System.out.println("Is Forget Password Link Visible? " + isForgetPassVisible);
		
		//find element by cssSelector
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		Thread.sleep(3000);
		
        boolean isTextDisplayed = driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed();
        if(isTextDisplayed == true) {
        	System.out.println("Your logged in successfully");
        }
        else {
        	System.out.println("Issue with user login");
        }
		
	}

}
