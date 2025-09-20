package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		
		//Select single option
		driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
		
		//Capture all options and find out size
		List<WebElement> options = driver.findElements(By.xpath("//h3[normalize-space()='Multi Selection']//following-sibling::div//ul//span[contains(text(),'choice')]"));
		System.out.println("Number of options :" +options.size());
		
		//Printing options from dropdown
		for(WebElement op: options) {
			System.out.println(op.getText());
		}
		
		//Select multiple options
		for(WebElement op: options) {
			String option = op.getText();
			if(option.equals("choice 4") || option.equals("choice 6 2 2") || option.equals("choice 7") )
			{
			    op.click();
		    }
	
	     }
		
   }

}
