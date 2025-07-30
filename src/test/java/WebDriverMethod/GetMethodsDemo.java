package WebDriverMethod;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethodsDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//get methods can be accessed by webdriver instance
		
		//get(URL) - open the url in browser
		driver.get("https://webdriveruniversity.com/index.html");
		
		//getTitle() - returns the title of the page
		System.out.println("Title of the Page is "+driver.getTitle());
		
		//getCurrentUrl() - return the URL of the page
		System.out.println("URL of the Page is "+driver.getCurrentUrl());
		
		//getPageSource() - returns the source code of the page
		//System.out.println("Page Source : " + driver.getPageSource());
		
		//getWindowHandle() - return ID of the single browser window
		System.out.println("Window Handle ID is "+ driver.getWindowHandle());
		
		//open another tab on the browser
		driver.findElement(By.xpath("//h1[normalize-space()='CONTACT US']")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		for (String id : windowIDs) {
		  System.out.println(id);
		}
	
	}

}
