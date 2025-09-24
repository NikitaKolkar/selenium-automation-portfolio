package JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//passing the text into input
		js.executeScript("arguments[0].setAttribute('value','Adam')",name);
		
		WebElement gender = driver.findElement(By.xpath("//label[normalize-space()='Female']"));
		//clicking on element
		js.executeScript("arguments[0].click()", gender);
		
		//scorll page down by pixel number
		//js.executeScript("window.scrollBy(0,1200)", "");
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scroll page till element is visible
		//WebElement ele = driver.findElement(By.xpath("//h2[normalize-space()='Static Web Table']"));
		//js.executeScript("arguments[0].scrollIntoView();", ele);
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//scroll page till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(3000);
		
		//scroll back to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		
		driver.close();
		
	}

}
