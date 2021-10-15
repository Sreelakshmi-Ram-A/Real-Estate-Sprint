package RealEstate.test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import RealEstate.pages.REAdminAddNewFeature;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class REAdminAddNewFeatureTest {
	static WebDriver driver;
	static REAdminAddNewFeature login;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\MYLAPTOP\\\\Desktop\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
		REAdminAddNewFeature login = new REAdminAddNewFeature(driver);
		driver.navigate().to("http://realty-real-estatem1.upskills.in/wp-admin/edit.php?post_type=property" );
		driver.manage().window().maximize();
	}
	// creating object of LoginPage class
	
	@Test
	public void SignIn()
	{
		REAdminAddNewFeature login = new REAdminAddNewFeature(driver);
		boolean success=login.AdminLogin("admin", "admin@123");
		AssertJUnit.assertEquals(success, true);
	}
	
	@Test
	public void Checkproperty()
	{
		REAdminAddNewFeature login = new REAdminAddNewFeature(driver);
		String curTitle= login.getRELoginTitle(driver);
		AssertJUnit.assertEquals(curTitle, "My Profile – Real Estate");
	}
		
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}




