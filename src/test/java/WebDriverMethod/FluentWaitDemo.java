package WebDriverMethod;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
		
		//Fluent wait declaration
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	    //Enter Username and password
        WebElement userName = mywait.until(new Function<WebDriver,WebElement>(){
        	public WebElement apply(WebDriver driver) {
        		return driver.findElement(By.xpath("//input[@placeholder='Username']"));
        }
	});
        
        userName.sendKeys("Admin");
        
       driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
       driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
       driver.close();
	}

}
