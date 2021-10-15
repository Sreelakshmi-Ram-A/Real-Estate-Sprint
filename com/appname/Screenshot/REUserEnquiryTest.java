package com.appname.Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appname.pages.REUserEnquiryPage;
import com.appname.pages.REUserLoginPage;

public class REUserEnquiryTest {
	static WebDriver driver;
	static REUserEnquiryPage post;
	
	@BeforeTest
	public void verifyPage()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "" );
		driver.manage().window().maximize();
		
		
		
		//driver.navigate().to("http://realty-real-estatem1.upskills.in/house-for-rent/");
	}
	
	@Test(priority=1, groups={"Regression Testing"})
	public void Enquiry() throws InterruptedException
	{   
		REUserLoginPage login = new REUserLoginPage(driver);
		boolean success=login.UserLogin("Sushmitha s", "8971030229");
		Assert.assertEquals(success, true);
		
		REUserEnquiryPage ser=new REUserEnquiryPage(driver);
		boolean nav=ser.goToSearch();
		
		Assert.assertEquals(success, true);
		Assert.assertEquals(nav, false);
	}
	
	 
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
