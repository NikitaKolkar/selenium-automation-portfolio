package Screenshots;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScreenshotDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//Take Full Page screenshots
		/*TakesScreenshot ts = (TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		//File target = new File("C:\\Workspaces\\SeleniumTest1\\SeleniumAutomationPortfolio\\Screenshots");
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage.png");
		srcfile.renameTo(target); //copy sourcefile 
		*/
		
		//Take screenshot of the specific area of the webpage
		/*WebElement list = driver.findElement(By.xpath("//select[@id='animals']"));
		File srcfile_list = list.getScreenshotAs(OutputType.FILE);
		File target_list = new File(System.getProperty("user.dir")+"\\Screenshots\\list.png");
		srcfile_list.renameTo(target_list);
		*/
		
		//Take screenshot of the webelement
		WebElement element = driver.findElement(By.xpath("//button[normalize-space()='START']"));
		File srcfile_ele = element.getScreenshotAs(OutputType.FILE);
		File target_ele = new File(System.getProperty("user.dir")+"\\Screenshots\\elememt.png");
		srcfile_ele.renameTo(target_ele);
		
		driver.close();
	}

}
