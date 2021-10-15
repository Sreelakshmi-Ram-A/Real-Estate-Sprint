package com.appname.Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


import com.appname.pages.REUserLoginPage;
import com.appname.pages.REUserProfilePage;
import com.appname.pages.REUserRemoveBookmarkPage;
public class REUserProfileTest {
	static WebDriver driver;
	static REUserLoginPage login;
	static REUserProfilePage user;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swathi\\OneDrive\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/");
		driver.manage().window().maximize();
		REUserLoginPage login = new REUserLoginPage(driver);
	}
	
	// creating object of LoginPage class
	@Test
	public void UserUpdate() throws InterruptedException
	{
		REUserLoginPage login = new REUserLoginPage(driver);
		boolean success=login.AdminLogin("swathi_m","swathi123");
		Assert.assertEquals(success, true);
		REUserProfilePage  user=new REUserProfilePage(driver);
		boolean success1=user.UserUpdate();
		Assert.assertEquals(success1,true);
		
		
	}
	/*
	@Test
	public void UpdateProfile() 
	{
		
		REUserProfilePage  user=new REUserProfilePage(driver);
		boolean success=user.UserUpdate();
		Assert.assertEquals(success,true);
	}*/
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
