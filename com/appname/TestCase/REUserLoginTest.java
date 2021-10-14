package com.appname.Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appname.pages.REUserLoginPage;

public class REUserLoginTest {
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
	@Test
	public void CorrectLogin() throws InterruptedException
	{
		REUserLoginPage login = new REUserLoginPage(driver);		
		boolean success2=login.UserLogin("Varshu", "Varshitha");
		String curTitle= login.getRELoginTitle(driver);		
		Assert.assertEquals(success2, true);
		Assert.assertEquals(curTitle, "My Profile – Real Estate");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
