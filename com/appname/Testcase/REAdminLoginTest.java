package RealEstate.Test;

import org.testng.annotations.Test;

import RealEstate.Pages.REAdminLogin;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class REAdminLoginTest {
	
		static WebDriver driver;
		static REAdminLogin login;
		@BeforeTest
		public void veryfylogin()
		{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
					+ "");
			driver.manage().window().maximize();
			REAdminLogin login = new REAdminLogin(driver);
		}
		// creating object of LoginPage class
		@Test
		public void CheckTitle()
		{
			REAdminLogin login = new REAdminLogin(driver);
			String curTitle= login.getRELoginTitle(driver);
			AssertJUnit.assertEquals(curTitle, "My Profile – Real Estate");		
		}
		@Test
		public void SignIn()
		{
			REAdminLogin login = new REAdminLogin(driver);
			boolean success=login.AdminLogin("mohankrishna176@gmail.com", "Secret@123&&");
			AssertJUnit.assertEquals(success, true);
		}
		@AfterTest
		public void teardown()
		{
			driver.quit();
		}
		
	}