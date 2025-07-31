package WebDriverMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practice.expandtesting.com/radio-buttons");
		
		//conditional methods can be accessed through webelement and it return the boolean value
		
		//isDisplayed()
		Boolean isRadiobtnVisible = driver.findElement(By.xpath("//label[normalize-space()='Blue']")).isDisplayed();
		System.out.println("Is Radiobutton Visible? : " + isRadiobtnVisible);
		
		//isEnabled()
		Boolean isValueEnabled = driver.findElement(By.xpath("//input[@id='green' and @name = 'color']")).isEnabled();
		System.out.println("Is Radiobutton enabled? : " + isValueEnabled);
		
		//isSelected()
		Boolean isOptionSelected = driver.findElement(By.xpath("//input[@id='blue' and @name = 'color']")).isSelected();
		System.out.println("Is Radiobutton selected? : "+isOptionSelected);
		Boolean isOptionSelected1 = driver.findElement(By.xpath("//input[@id='red' and @name = 'color']")).isSelected();
		System.out.println("Is Radiobutton selected? : "+isOptionSelected1);
		
	}

}
