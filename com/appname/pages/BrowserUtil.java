package com.appname.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BrowserUtil {

	public static WebDriver startBrowser(String browsertype, String url) {
		
		String exePath1="C:\\Users\\Sreelakshmi Ram.A\\Documents\\geckodriver-v0.30.0-win64\\geckodriver.exe";
		String exePath2="C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe";

		WebDriver driver=null;
		switch (browsertype)
		{
		case "firefox":
			System.setProperty("webdriver.gecko.driver", exePath1);
			driver=new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",exePath2);
			driver=new ChromeDriver();
			break;
		default:
			break;
		}	
		driver.get(url);
		return driver;
	}
}
