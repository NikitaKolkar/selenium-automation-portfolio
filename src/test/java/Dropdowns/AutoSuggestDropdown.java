package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		//Entering search value
		driver.findElement(By.xpath("//textarea[@role='combobox']")).sendKeys("Selenium");
		Thread.sleep(3000);
		
		//Selecting value from the search suggestion
		List<WebElement> ls = driver.findElements(By.xpath("//ul[@role='listbox']//div[@role='option']//span[contains(text(),'selenium')]"));																																																								
		
		for(WebElement lst:ls)
		{
			if(lst.getText().equals("selenium testing"))
			{
				lst.click();
				break;
			}
		}
	}

}																											
																						 