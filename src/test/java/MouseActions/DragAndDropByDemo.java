package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropByDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		Actions act = new Actions(driver);
		
		//Moving min-silder
		WebElement minSlider = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
		System.out.println("Default Location of the slider :"+minSlider.getLocation()); //(59, 249)
		
		act.dragAndDropBy(minSlider, 160, 0).perform();
		
		System.out.println("Slider Location after moving :"+ minSlider.getLocation());
		
		//Moving max-slider
		WebElement maxSlider = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
        System.out.println("Default Location of the slider :"+maxSlider.getLocation()); //(510, 249)
		
		act.dragAndDropBy(maxSlider, -100, 0).perform();
		
		System.out.println("Slider Location after moving :"+ maxSlider.getLocation());
		
		driver.close();

	}

}
