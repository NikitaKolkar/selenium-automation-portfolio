package Locators;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://money.rediff.com/gainers/nse/weekly/groupall");
		
		//Self Node - Selects the current node
		String text = driver.findElement(By.xpath("//a[contains(text(),'Times Guaranty')]/self::a")).getText();
		System.out.println(text);
		
		//Parent - Selects the parent of the current node (always one)
		text=driver.findElement(By.xpath("//a[contains(text(),'Times Guaranty')]/parent::td")).getText();
		System.out.println(text);
		
		//Child - Selects all children of the current node (One or many)
		List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'Times Guaranty')]/ancestor::tr/child::*"));
		System.out.println("Text within all tags are as below:");
		for(WebElement c : childs)
		{
			System.out.println(c.getText());
		}
		
		//Ancestor - Selects all ancestors (parent, grandparents) of current node
		text=driver.findElement(By.xpath("//a[contains(text(),'Times Guaranty')]/ancestor::tr")).getText();
		System.out.println("Ancestors of the current node: "+text);
		
		//Descendant - Selects all descendants (children, grandchildren) of the current node 
		text=driver.findElement(By.xpath("//a[contains(text(),'Times Guaranty')]/ancestor::tr/descendant::a[text()='Buy']")).getDomAttribute("href");
		System.out.println("Href attribute value of the descendant "+text);
		
		//Following - Selects all elements after the closing tag of the current node
		List<WebElement> folNodes = driver.findElements(By.xpath("//a[contains(text(),'Times Guaranty')]/following::*"));
		System.out.println("Number of following nodes " + folNodes.size());
		
		//Following-Sibling - Selects all siblings after the current node
		List<WebElement> folsibNodes = driver.findElements(By.xpath("//a[contains(text(),'Times Guaranty')]/ancestor::tr/following-sibling::tr"));
		System.out.println("Number of following-sibling nodes " + folsibNodes.size());
		
		//Preceding - Select all nodes present before the current node
		List<WebElement> preNodes = driver.findElements(By.xpath("//a[contains(text(),'Times Guaranty')]/ancestor::tr/preceding::tr"));
		System.out.println("Number of preceding nodes "+ preNodes.size());
		
		//Preceding-Sibling - Selects all sibling before the current node
		List<WebElement> presibNodes = driver.findElements(By.xpath("//a[contains(text(),'Times Guaranty')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Number of preceding-sibling"+ presibNodes.size());
		
		driver.close();

	}

}
