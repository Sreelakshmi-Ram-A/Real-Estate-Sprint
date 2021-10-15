package com.appname.pages;

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
	    
		String exePath = "C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe";
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

//The below function verifyLink(String urlLink) verifies any broken links and return the server status. 
	public static void verifyLink(String urlLink) {
     //Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
     try {
			//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
			URL link = new URL(urlLink);
			// Create a connection using URL object (i.e., link)
			HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
		
			//Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);
			//connect using connect method
			
			httpConn.connect();
			//use getResponseCode() to get the response code. 
				if(httpConn.getResponseCode()== 200) {	
					//System.out.println(urlLink+" - "+httpConn.getResponseMessage());
				}
				if(httpConn.getResponseCode()== 404) {
					System.out.println(urlLink+" - "+httpConn.getResponseMessage());
				}
			}
			//getResponseCode method returns = IOException - if an error occurred connecting to the server. 
		catch (Exception e) {
			//e.printStackTrace();
			System.err.println(urlLink+ " " + e.getCause());
			
		}
 } 
}
