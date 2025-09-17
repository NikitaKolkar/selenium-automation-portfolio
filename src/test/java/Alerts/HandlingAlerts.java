package Alerts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		//Normal Alert with OK button 
		/* 
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]")).click();
		Thread.sleep(3000);
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();//close alert using OK button
		*/
		
		//Confirmation Alert with OK and Cancel button 
		/*
		driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='click the button to display a confirm box']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss(); //close alert using Cancel button
		*/
		
		//Alert with Textbox 					
		
		driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Test");
		driver.switchTo().alert().accept();
		String actualText = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
		String expectedText = "Hello Test How are you today";
		if(actualText.equals(expectedText)) {
			System.out.println("Test is passed");
		}

	}

}
