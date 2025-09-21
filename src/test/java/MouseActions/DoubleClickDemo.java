package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml5_ev_ondblclick");
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frame);
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Double-click me']"));
		
		//Double Click Action
		Actions action = new Actions(driver);
		action.doubleClick(button).perform();
		System.out.println("Text displayed after double clicking is : "+ driver.findElement(By.xpath("//p[@id='demo']")).getText());
		
		driver.close();

	}

}
