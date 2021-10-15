package com.appname.Testcase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.appname.pages.REUserRemoveBookmarkPage;
import com.appname.pages.REUserLoginPage;

public class REUserRemoveBookmarkTest {
	static WebDriver driver;
	static REUserRemoveBookmarkPage book;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swathi\\OneDrive\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/"+ "");
		driver.manage().window().maximize();
		
	}
	@Test
	public void RemoveBookmark() throws InterruptedException
	{
		REUserLoginPage login = new REUserLoginPage(driver);
		boolean success=login.AdminLogin("swathi_m", "swathi123");
		Assert.assertEquals(success, true);
		REUserRemoveBookmarkPage books=new REUserRemoveBookmarkPage(driver);
		boolean success1=books.Bookmark();
		Assert.assertEquals(success1, true);
		
	}
	/*@Test
	public void list()
	{
		REUserBookmarkPage books=new REUserBookmarkPage(driver);
		boolean success1=books.Bookmark();
		Assert.assertEquals(success1, true);
	}*/
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}