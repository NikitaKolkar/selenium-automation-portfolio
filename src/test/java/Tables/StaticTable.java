package Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//find number of rows in table
		System.out.println("Rows in Static Table: "+driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size()); //7

		//find number of columns in table
		System.out.println("Coulmns in Static Table: " + driver.findElements(By.xpath("//table[@name='BookTable']//th")).size()); //4
		
		//Read data from specific row and columns
		System.out.println("Data in 3rd column of the 4th row is: " +driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[3]")).getText());
		
		//Read data from all rows and columns
		System.out.println("----Table Data----");
		for(int r=2;r<=7;r++)
		{
			for(int c=1;c<=4;c++)
			{
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		
		//Print the bookname if author is Amit
		for(int r=2;r<=7;r++)
		{
			String aut = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(aut.equals("Amit"))
			{
				System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText());
			}

		}
		
		//Find Total Sum of price of all books
		int sum=0;
		for(int r=2;r<=7;r++)
		{
			String aut = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			sum=sum+Integer.parseInt(aut);
		}
		System.out.println("Total Price of all Books: "+ sum);
		
		driver.close();
	}

}
