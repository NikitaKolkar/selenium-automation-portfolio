package Dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	    //Login Steps
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Clicking on PIM
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		//Clicking on the Job Title dropdown
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
		
		//count number of options present
		List<WebElement> ops = driver.findElements(By.xpath("//div[@role='listbox']//div//span"));
		System.out.println("Number of options present: " + ops.size());
		
		//Printing all options present
		for(WebElement op: ops) {
			System.out.println(op.getText());
		}
		//selecting single option
		driver.findElement(By.xpath("//span[normalize-space()='Chief Technical Officer']")).click();
		
	    driver.close();

	}

}
