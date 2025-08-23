package WebDriverMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationCommandsDemo {

	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
		//driver.get("https://practice.expandtesting.com/inputs");  //accepts URL only in string format
		
		//URL myUrl = new URI("https://practice.expandtesting.com/inputs").toURL();
		//driver.navigate().to(myUrl);
		
		driver.navigate().to("https://practice.expandtesting.com/");
		
		WebElement testInput = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Test Login Page']")));
		testInput.click();
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl()); //https://practice.expandtesting.com/
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl()); //https://practice.expandtesting.com/input
	
		driver.navigate().refresh();
		
		driver.close();

	}

}
