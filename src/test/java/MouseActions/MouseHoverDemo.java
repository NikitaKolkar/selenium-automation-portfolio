package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		WebElement navlink = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement childlink = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions action = new Actions(driver);
		
		//Mouse Hover
		//action.moveToElement(navlink).moveToElement(childlink).click().build().perform();

		action.moveToElement(navlink).moveToElement(childlink).click().perform();
		
		driver.close();

	}

}
