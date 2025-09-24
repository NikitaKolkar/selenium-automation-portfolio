package UploadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MutipleFileUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement ele = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		String file1 = "C:\\Workspaces\\First File.txt";
		String file2 = "C:\\Workspaces\\Second File.txt";
		
		ele.sendKeys(file1 + "\n" + file2);
		
		driver.findElement(By.xpath("//button[normalize-space()='Upload Multiple Files']")).click();
		
		String text = driver.findElement(By.xpath("//p[@id='multipleFilesStatus']")).getText();
		
		if(text.contains("First File.txt") && text.contains("Second File.txt"))
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
