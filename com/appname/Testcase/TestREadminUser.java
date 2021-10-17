package RealEstate.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.junit.*;

//import pages.REAdminLoginPage;
//import pages.REAdminma;
import RealEstate.pages.*;

public class TestREadminUser {

	static WebDriver driver;
	static REadminUser user;
	
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "E:\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
			//+ "");
		driver.get("http://realty-real-estatem1.upskills.in/wp-admin/upload.php");
		driver.manage().window().maximize();
		REadminUser user = new REadminUser(driver);
	}
	
	@Test
	public void SignIn()
	{
		REAdminLoginPage media = new REAdminLoginPage(driver);
		boolean success=media.AdminLogin("admin", "Secret@123&&");
		Assert.assertEquals(success, true);
	}
	
	@Test
	public void Users()
	{
		REadminUser user = new REadminUser(driver);
		boolean success=user.AllUser();
		Assert.assertEquals(success, true);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	

}
