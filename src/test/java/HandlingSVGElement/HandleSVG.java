package HandlingSVGElement;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSVG {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//Locating svg element
		WebElement element1 = driver.findElement(By.xpath("//*[name()='circle' and contains(@cx,'15')]"));
		
		//Taking screenshot of the element
		File srcfile_ele = element1.getScreenshotAs(OutputType.FILE);
		File target_ele = new File(System.getProperty("user.dir")+"\\Screenshots\\circle.png");
		srcfile_ele.renameTo(target_ele);
		
		driver.quit();

	}

}
