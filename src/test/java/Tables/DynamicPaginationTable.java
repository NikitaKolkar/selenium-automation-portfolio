package Tables;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		WebElement element = driver.findElement(By.xpath("//select[@class='dt-input']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
        
        //Update the number of rows displayed per page in the table
      	driver.findElement(By.xpath("//option[@value='25']")).click();
        
        //Find the number of columns present in the table
        int cols = driver.findElements(By.xpath("//table//colgroup//col")).size();
        
        //Find the number of rows present in the table
        int rows = driver.findElements(By.xpath("//tbody[@class='row-striping row-hover']//tr")).size();
		
		//Find the number of pages displayed in the table
		List<WebElement> pages = driver.findElements(By.xpath("//button[contains(text(),'›')]//preceding-sibling::button[@class='dt-paging-button' or @class='dt-paging-button current']"));
		int lastPage = 0;
		for(WebElement pno: pages)
		{
			int currentNo = Integer.parseInt(pno.getText());
			if(currentNo>lastPage)
			{
				lastPage=currentNo;
			}
		}
		
		//Print all the data from current page
		System.out.println("Page 1");
		for(int r=2;r<=rows;r++) {
			for(int c=1;c<=cols;c++)
			{
				String value = driver.findElement(By.xpath("//tbody[@class='row-striping row-hover']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value + "\t");
			}
			System.out.println();
		}
		
		//click on page number buttons and print all rows and columns of the current page till second last page
		for(int i=2;i<lastPage;i++)
		{
			System.out.println("Page "+i);
			WebElement nxtpg = driver.findElement(By.xpath("//button[@class='dt-paging-button' or @class='dt-paging-button current'][contains(text(),"+i+")]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("arguments[0].scrollIntoView(true);", nxtpg);
	        js1.executeScript("arguments[0].click();", nxtpg);
			for(int r=2;r<=rows;r++) {
				for(int c=1;c<=cols;c++)
				{
					String value = driver.findElement(By.xpath("//tbody[@class='row-striping row-hover']//tr["+r+"]//td["+c+"]")).getText();
					System.out.print(value + "\t");
				}
				System.out.println();
			}
			
		}
		
		//click on last page and find out the number of rows
		WebElement lstpg = driver.findElement(By.xpath("//button[@class='dt-paging-button' or @class='dt-paging-button current'][contains(text(),"+lastPage+")]"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true);", lstpg);
        js2.executeScript("arguments[0].click();", lstpg);
        int lstrow = driver.findElements(By.xpath("//tbody[@class='row-striping row-hover']//tr")).size();
        System.out.println("Page "+lastPage);
		for(int r=2;r<=lstrow;r++) {
			for(int c=1;c<=cols;c++)
			{
				String value = driver.findElement(By.xpath("//tbody[@class='row-striping row-hover']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value + "\t");
			}
			System.out.println();
		}
		driver.close();
	}

}
