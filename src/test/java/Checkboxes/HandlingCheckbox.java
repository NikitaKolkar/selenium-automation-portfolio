package Checkboxes;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlingCheckbox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://total-qa.com/checkbox-example/");
		// 1. Select specific checkbox
		//driver.findElement(By.xpath("(//input[@name='chk'])[2]")).click();
		
		//2. Select all checkboxes
		List<WebElement> checkBoxes = driver.findElements(By.xpath("(//input[@name='chk'])"));
		int checkCount = checkBoxes.size();
		/*
		for(WebElement checkbox: checkBoxes) {
			checkbox.click();
		} 
		*/
		
		//3. Select last 3 checkboxes dynamically
		/*
		for(int i=checkCount -3;i<checkCount;i++) {
			checkBoxes.get(i).click();
		}
		*/
		
		//4. Select first 3 checkboxes dynamically
		
		for(int i=0;i<3;i++) {
			checkBoxes.get(i).click();
		}
		
		//Deselect selected checkbox 
		for(int i=0;i<checkCount;i++) {
			if(checkBoxes.get(i).isSelected()==true) {
				checkBoxes.get(i).click();
			}
		}
	

	}

}
