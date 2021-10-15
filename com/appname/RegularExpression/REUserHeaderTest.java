package com.appname.Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appname.pages.REUserHeaderPage;
import com.appname.pages.REUserLoginPage;

public class REUserHeaderTest {
	static WebDriver driver;
	static REUserLoginPage login;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void RegexCheck() throws InterruptedException
	{
		REUserLoginPage login = new REUserLoginPage(driver);		
		boolean success1=login.UserLogin("Varshu", "Varshitha");		
		Assert.assertEquals(success1, true);
		
		REUserHeaderPage regex = new REUserHeaderPage(driver);		
		boolean success2=regex.checkHeadingBegining();		
		Assert.assertEquals(success2, true);
		
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
