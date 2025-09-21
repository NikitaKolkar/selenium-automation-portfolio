package DatePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='resp-tabs-list ']//li[@id='DropDown DatePicker']")));
	    element.click(); 
	    
		//Switch to iframe
	    WebElement frame1 = driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame1);
		
		//Date to select in Date Picker
		String date = "18";
		String month = "Feb";
		String year = "2026";
		
		//Click on Date Picker
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//Select month and year
		while(true)
			{
			WebElement curMon = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		    Select mon = new Select(curMon);
		    WebElement selmon = mon.getFirstSelectedOption();
		    String curMonth = selmon.getText();
		    
		    WebElement curY = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		    Select yy = new Select(curY);
		    WebElement selYear = yy.getFirstSelectedOption();
		    String curYear = selYear.getText();
		    
			if(curMonth.equals(month) && curYear.equals(year)) 
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			
			}
		
	    //Select a Date
		List<WebElement> dates = driver.findElements(By.xpath("//tbody//tr//a[contains(@class,'ui-state-default')]"));
		for(WebElement d:dates)
			{
			if(d.getText().equals(date))
			  {
				d.click();
				break;
				
			  }
			}
	}

}
