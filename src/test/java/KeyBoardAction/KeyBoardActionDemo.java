package KeyBoardAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Mumbai");
		
		Actions action = new Actions(driver);
		
		//Ctrl + A - select a text
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//Ctrl + C - copy the text
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//Tab - Move to next field
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//Ctrl + V - paste the copied text
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		//Tab - Move to next field
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//Enter
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
		//Print the submitted data 
		System.out.println(driver.findElement(By.xpath("//p[@id='currentAddress']")).getText());
		System.out.println(driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText());
		
		driver.close();

	}

}
