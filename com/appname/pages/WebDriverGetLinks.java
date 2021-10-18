package RealEstate.Pages;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetLinks {

	public static void main(String[] args) {
	    WebDriver driver;
	    
		String exePath = "C:\\Program Files (x86)\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/");
		
		//Read ALL the links in the page into a collection of type List 
		java.util.List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		 
		System.out.println("No of links: " + allLinks.size());
		 
		for (WebElement l: allLinks) {
			 
			//print the links i.e. http://example.com or https://www.example.com
			//print the links text
			
			//System.out.println(l.getText()+ " --" + l.getAttribute("href"));

			
		verifyLink(l.getAttribute("href"));
		
		}
		System.out.println("***********End of Execution****************");

	}

	private static void verifyLink(String attribute) {
		// TODO Auto-generated method stub
		
	}
}