package Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorsDemo2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		//find element by xpath with inner text
		boolean isHeaderDisplayed = driver.findElement(By.xpath("//h1[text()='CURA Healthcare Service']")).isDisplayed();
		if (isHeaderDisplayed==true) {
			System.out.println("Title is displayed");
		}
		//find element by xpath with single attribute
		driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
		
		//find element by xpath with multiple attribute
		//driver.findElement(By.xpath("//input[@id='txt-username'][@placeholder='Username']")).sendKeys("John Doe");
		
		//find element by xpath with 'or' operator
		driver.findElement(By.xpath("//input[@id='txt-username' or @name ='username']")).sendKeys("John Doe");
		
		//find element by xpath with 'and' operator
		driver.findElement(By.xpath("//input[@id='txt-password' and @name='password']")).sendKeys("ThisIsNotAPassword");
		
		//find element by xpath with inner text
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(3000);
		//find element by xpath with contains()
		boolean isButtonVisible = driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).isDisplayed();
		if(isButtonVisible==true) {
			System.out.println("User logged in successfully");
		}
		
		
	}

}
