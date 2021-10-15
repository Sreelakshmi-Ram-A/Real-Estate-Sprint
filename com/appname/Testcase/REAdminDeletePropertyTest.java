package RealEstate.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import RealEstate.pages.REAdminAddPropertySettings;
import RealEstate.pages.REAdminDeleteProperty;

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
		REAdminDeleteProperty login = new REAdminDeleteProperty(driver);
		boolean success=login.AdminLogin("admin", "admin@123");
		AssertJUnit.assertEquals(success, true);
	}
	
	@Test
	public void Checkproperty()
	{
		REAdminDeleteProperty  login = new REAdminDeleteProperty(driver);
		String curTitle= login.getRELoginTitle(driver);
		AssertJUnit.assertEquals(curTitle, "My Profile – Real Estate");		//Properties ‹ Real Estate — WordPress
	}
	
	/*@Test
	public void Property()
	{
		REAdminPropertiesPage login = new REAdminPropertiesPage(driver);
		boolean done=login.propertyEdit1(driver);
		AssertJUnit.assertEquals(done, true);
	}*/
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}


			  