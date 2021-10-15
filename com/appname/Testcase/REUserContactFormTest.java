package com.appname.Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.appname.pages.REUserContactFormPage;
import com.appname.pages.REUserLoginPage;


public class REUserContactFormTest {
	static WebDriver driver;
	static REUserContactFormPage con;
	@BeforeTest
	public void verifyRegister()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\OneDrive\\Documents\\Capgemini  Training\\Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/"+ "");
		driver.manage().window().maximize();
		REUserContactFormPage reg= new REUserContactFormPage(driver);
	}
	@Test
	public void Contact()
	{
		//Calling
		REUserLoginPage login = new REUserLoginPage(driver);
		boolean success=login.AdminLogin("Varshu", "Varshitha");	
		Assert.assertEquals(success, true);
	
		REUserContactFormPage login1 = new REUserContactFormPage(driver);
		boolean success1=login1.ContactForm("aaa","aaa@gmsil.com","service","aaa");
		Assert.assertEquals(success1, false);
			
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
