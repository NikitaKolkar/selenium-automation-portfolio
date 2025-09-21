package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement button = driver.findElement(By.xpath("//p//span[text()='right click me']"));
		
		Actions action= new Actions(driver);
		
		//Right Click
	    action.contextClick(button).perform();
		driver.findElement(By.xpath("//ul//span[text()='Copy']")).click();
		driver.switchTo().alert().accept();
		
		driver.close();

	}

}
