package com.appname.Testcase;

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
	public void CorrectLogin() throws InterruptedException, IOException
	{
		//Properties is smoething that operates on key and values
		
		Properties obj=new Properties();
		FileInputStream objfile=new FileInputStream("UserLogin.properties");
		obj.load(objfile);
		String s_un=obj.getProperty("username");
		String s_pw=obj.getProperty("password");
		
		
		REUserLoginPage login = new REUserLoginPage(driver);		
		boolean success2=login.UserLogin(s_un,s_pw);
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
