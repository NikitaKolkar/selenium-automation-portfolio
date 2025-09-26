package ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsUsage {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		//SSL Handling
		/* options.setAcceptInsecureCerts(true); //accepts ssl certificate
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");	
		String title = driver.getTitle();
		
		if(title.equals("expired.badssl.com"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}*/
		
		//Remove "Chrome is being controlled by automated test software message"
		/*options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		*/
		
		//Run the test in Incognito mode
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		

	}

}
