package BrokenLinks;


import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='broken-links']//a"));
		System.out.println("Total Links present on the screen are " + links.size());
		
		for(WebElement link: links) {
			String href = link.getAttribute("href");
			if(href==null || href.isEmpty())
			{
				System.out.println("No href value present");
				continue;
			}
			try {
				URL url = new URI(href).toURL(); //coverted the href value from string to URL
				HttpURLConnection con =(HttpURLConnection)url.openConnection(); //open connection to the server
				con.connect(); // connect to server and send request to the server
				
				if(con.getResponseCode()>=400) //status code >= 400  --> Broken Link
				{
					System.out.println(href + ": Broken Link");
				}
				else
				{
					System.out.println(href + ": Not a Broken Link");
				}
				
			}
			catch(Exception e)
			{
			}
		}
		driver.quit();
	}

}
