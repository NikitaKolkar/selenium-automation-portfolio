package JavascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//Minimize the window
		driver.manage().window().minimize();
		
		Thread.sleep(3000);
		//Maximize the window
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
			
		js.executeScript("document.body.style.zoom = '50%'", ""); //set the zoom to 50%
		Thread.sleep(3000);
		
		js.executeScript("document.body.style.zoom = '90%'", ""); //set the zoom to 50%
		
	    driver.close();
		

	}

}
