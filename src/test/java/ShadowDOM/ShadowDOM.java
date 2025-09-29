package ShadowDOM;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
	    //Locate element inside single shadow DOM
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
		Thread.sleep(2000);
		System.out.println(shadow.findElement(By.cssSelector(".info")).getText());
		
		//Locate element inside 2 nested shadow DOM
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#nested_shadow_host")).getShadowRoot();
		Thread.sleep(2000);
		System.out.println(shadow1.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(1)")).getText());
					
        driver.quit();

	}

}
