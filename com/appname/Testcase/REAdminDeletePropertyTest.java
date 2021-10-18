package RealEstate.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import RealEstate.pages.REAdminDeleteProperty;
import RealEstate.pages.REAdminLoginPage;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class REAdminDeletePropertyTest {
	static WebDriver driver;
	static REAdminDeleteProperty  login;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\MYLAPTOP\\\\Desktop\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
		REAdminDeleteProperty login = new REAdminDeleteProperty(driver);
		driver.navigate().to("http://realty-real-estatem1.upskills.in/wp-admin/edit.php?post_type=property" );
		driver.manage().window().maximize();
	}
	// creating object of LoginPage class
	
	@Test
	public void SignIn() throws InterruptedException
	{
		REAdminLoginPage login = new REAdminLoginPage(driver);
		boolean success=login.AdminLogin("mohankrishna176@gmail.com", "Secret@123&&");
		AssertJUnit.assertEquals(success, true);
		REAdminDeleteProperty login1 = new REAdminDeleteProperty(driver);
		boolean success1=login1.AdminLogin();
		AssertJUnit.assertEquals(success1, true);
	}
			
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}





  


			  