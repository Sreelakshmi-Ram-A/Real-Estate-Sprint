package RealEstate.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RealEstate.pages.REAdminLoginPage;

public class REAdminLoginTest {
	static WebDriver driver;
	static REAdminLoginPage login;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
		REAdminLoginPage login = new REAdminLoginPage(driver);
	}
	// creating object of LoginPage class
	@Test
	public void CheckTitle()
	{
		REAdminLoginPage login = new REAdminLoginPage(driver);
		String curTitle= login.getRELoginTitle(driver);
		Assert.assertEquals(curTitle, "My Profile – Real Estate");		
	}
	@Test
	public void SignIn()
	{
		REAdminLoginPage login = new REAdminLoginPage(driver);
		boolean success=login.AdminLogin("admin", "Secret@123&&");
		Assert.assertEquals(success, true);
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}

