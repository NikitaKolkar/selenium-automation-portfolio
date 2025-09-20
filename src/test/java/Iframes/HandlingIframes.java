package Iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingIframes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practice.expandtesting.com/iframe");
		
		//switch to 1st frame using Frame WebElement
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(frame1);
		
		//switch to frame using ID attribute
		//driver.switchTo().frame("mce_0_ifr");
		
	    String sentence = 	driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]")).getText();
	    System.out.println(sentence);
	    driver.findElement(By.xpath("//p[normalize-space()='Your content goes here.']")).sendKeys("Text update");
        System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]")).getText());
        
        //switch back to default page from 
        driver.switchTo().defaultContent();
        
        //switch to 2nd Frame
        driver.switchTo().frame("email-subscribe");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nikita@gmail.com");
        
        WebElement element = driver.findElement(By.xpath("//button[@id='btn-subscribe']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
      
        String msg = driver.findElement(By.xpath("//div[@id='success-message']")).getText();
        System.out.println(msg);
        
        driver.switchTo().defaultContent();
        
        driver.close();
	}

}
