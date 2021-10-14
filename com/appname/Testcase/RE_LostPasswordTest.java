package com.appname.Testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appname.pages.REUserRegisterPage;
import com.appname.pages.RE_LostPasswordPage;

public class RE_LostPasswordTest {
	static WebDriver driver;
	static RE_LostPasswordPage reg;
	@BeforeTest
	public void verifyPage()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
		RE_LostPasswordPage reg = new RE_LostPasswordPage(driver);
	}
	
	@Test
	public void getPassword() throws InterruptedException
	{
		
		RE_LostPasswordPage login = new RE_LostPasswordPage(driver);
		boolean success=login.LostPassword("Wrong Login", "wrong@123");
		Assert.assertEquals(success, true);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
