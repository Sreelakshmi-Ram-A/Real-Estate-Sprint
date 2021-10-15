package com.appname.Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appname.pages.REUserContactFormPage;
import com.appname.pages.REUserLoginPage;
import com.appname.pages.REUserPasswordChangePage;

public class REUserPasswordChangeTest {
	static WebDriver driver;
	static REUserPasswordChangePage psw;
	
	@BeforeTest
	public void verifyRegister()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\OneDrive\\Documents\\Capgemini  Training\\Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/"+ "");
		driver.manage().window().maximize();

	}
	
	@Test 
	public void SignIn()
		{
			//Calling
			REUserLoginPage login = new REUserLoginPage(driver);
			boolean success=login.AdminLogin("Varshu", "Varshitha");	
			Assert.assertEquals(success, true);
				
			REUserPasswordChangePage psw = new REUserPasswordChangePage(driver);
			boolean success1=psw.PasswordChange("Varshitha", "Varshitha", "Varshitha");
			Assert.assertEquals(success1, true);	
		
		}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
