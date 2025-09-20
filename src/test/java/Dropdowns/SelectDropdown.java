package Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.automationtesting.co.uk/dropdown.html");
		WebElement drpdown = driver.findElement(By.xpath("//select[@id='cars']"));
		Select drpCars = new Select(drpdown);
		 
		//verify if the dropdown is multiselect
		System.out.println("Is the dropdown multiselect :" + drpCars.isMultiple());
		
		//select option from the dropdown
		//drpCars.selectByVisibleText("Honda");
		//drpCars.selectByIndex(4);
		drpCars.selectByValue("mercedes");
		
		WebElement optSelected = drpCars.getFirstSelectedOption();
		System.out.println(optSelected.getText());
	
		//capture options from dropdown
		List<WebElement> options = drpCars.getOptions();
		System.out.println("Total options present: "  + options.size());
		
		//printing all options
		for(WebElement opt:options) {
			System.out.println(opt.getText());
		}
		
		driver.close();

	}

}
