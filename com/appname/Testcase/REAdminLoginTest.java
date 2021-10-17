/**
 * 
 */
package com.appname.Testcase;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appname.pages.REAdminLoginPage;

public class REAdminLoginTest {
	static WebDriver driver;
	static REAdminLoginPage login;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
		REAdminLoginPage login = new REAdminLoginPage(driver);
	}
	// creating object of LoginPage class

	@Test
	public void SignIn() throws IOException
	{
		//Properties is something that operates on key and values
		
				Properties obj=new Properties();
				FileInputStream objfile=new FileInputStream("AdminLogin.properties");
				obj.load(objfile);
				String s_an=obj.getProperty("adminname");
				String s_pw=obj.getProperty("password");
		
		
		REAdminLoginPage login = new REAdminLoginPage(driver);
		
		String curTitle= login.getRELoginTitle(driver);
		Assert.assertEquals(curTitle, "My Profile – Real Estate");
		
		boolean success=login.AdminLogin(s_an,s_pw);
		Assert.assertEquals(success, true);
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
