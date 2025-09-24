package UploadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleFileUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement ele = driver.findElement(By.xpath("//input[@id='singleFileInput']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		
		ele.sendKeys("C:\\Workspaces\\Test.txt");
		driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']")).click();
		
		String text = driver.findElement(By.xpath("//p[@id='singleFileStatus']")).getText();
		if(text.equals("Single file selected: Test.txt, Size: 16 bytes, Type: text/plain"))
		{
			System.out.println("File uploaded successfully");
		}
		else
		{
			System.out.println("Upload Failed");
		}
		
		driver.close();

	}

}
