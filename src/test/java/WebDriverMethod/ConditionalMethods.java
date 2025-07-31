package WebDriverMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		//conditional methods can be accessed through webelement and it return the boolean value
		
		//isDisplayed()
		Boolean isDropdownVisible = driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']")).isDisplayed();
		System.out.println("Is Dropdown Visible? : " + isDropdownVisible);
		
		//isEnabled()
		Boolean isValueEnabled = driver.findElement(By.xpath("//input[@value='lettuce']")).isEnabled();
		System.out.println("Is Radiobox option enabled? : " + isValueEnabled);
		
		//isSelected()
		Boolean isOptionSelected = driver.findElement(By.xpath("//input[@value='pumpkin']")).isSelected();
		System.out.println("Is Radiobutton selected? : "+isOptionSelected);
		Boolean isOptionSelected1 = driver.findElement(By.xpath("//input[@value='lettuce']")).isSelected();
		System.out.println("Is Radiobutton selected? : "+isOptionSelected1);
		
	}

}
