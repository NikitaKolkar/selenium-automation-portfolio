package KeyBoardAction;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practice.expandtesting.com/");
		
		WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='About']"));
		
		Actions act = new Actions(driver);
		
		//open a link in a new tab
		act.keyDown(Keys.CONTROL).click(ele).keyUp(Keys.CONTROL).perform();

		//switch to new tab
		List<String> ids = new ArrayList(driver.getWindowHandles());
		
	    driver.switchTo().window(ids.get(1));
	   
	    //switch back to previous window tab
	    driver.switchTo().window(ids.get(0));
	    
	    //open a new url in new tab
	    driver.switchTo().newWindow(WindowType.TAB);
	    
	    driver.get("https://awesomeqa.com/ui/");
		

	}

}
