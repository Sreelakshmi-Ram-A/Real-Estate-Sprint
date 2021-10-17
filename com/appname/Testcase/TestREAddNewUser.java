package RealEstate.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import RealEstate.pages.*;
public class TestREAddNewUser {
	static WebDriver driver;
	static REAddNewUser user;
	
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "E:\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
			+ "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://realty-real-estatem1.upskills.in/wp-admin/user-new.php" );
		driver.manage().window().maximize();
	}
	@Test
	public void SignIn()
	{
		REAddNewUser login = new REAddNewUser (driver);
		boolean success=login.AdminLogin("admin", "Secret@123&&");
		AssertJUnit.assertEquals(success, true);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	

}



