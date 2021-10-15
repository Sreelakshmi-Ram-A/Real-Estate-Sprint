package com.appname.Testcase;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appname.pages.REAdminLoginPage;
import com.appname.pages.REUserHeaderPage;
import com.appname.pages.REUserLoginPage;

public class REAdminHeaderTest {
	static WebDriver driver;
	static REUserLoginPage login;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ss145\\OneDrive - Capgemini\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void RegexCheck() throws InterruptedException
	{
		REAdminLoginPage login = new REAdminLoginPage(driver);
		boolean success=login.AdminLogin("admin", "admin@123");
		Assert.assertEquals(success, true);
		
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
