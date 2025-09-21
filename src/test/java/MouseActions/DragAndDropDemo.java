package MouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
	    WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Accepted Elements']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
        
	  //Switch to iframe
	    WebElement frame = driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		WebElement source = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']//p"));
		
		//Drag and drop
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
		driver.close();
		
		

	}

}
