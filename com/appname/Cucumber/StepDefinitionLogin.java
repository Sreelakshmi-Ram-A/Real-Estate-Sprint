package com.appname.StepDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.appname.pages.REUserLoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionLogin {
	static WebDriver driver;
	static REUserLoginPage login;
	@Before
	public void veryfylogin()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@Given("User is in login page")
	public void navigate(){
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "" );
		String curTitle= login.getRELoginTitle(driver);		
		Assert.assertEquals(curTitle, "My Profile – Real Estate");
	       }
	
	@When ("user enters correct {string} and {string} and clicks login")
	public void login(String username,String password) throws InterruptedException{
		login.UserLogin(username,password);
	       }
	
	@Then("User homepage should be loaded successfully")
	public void verifySuccessful(){
		boolean isloginsuccess=login.isHeaderFound();
		Assert.assertEquals(isloginsuccess, true);
	      }
}
