package ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessExecution {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://awesomeqa.com/ui/index.php?route=account/login");	
		String title = driver.getTitle();
		
		if(title.equals("Account Login"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		

	}

}
