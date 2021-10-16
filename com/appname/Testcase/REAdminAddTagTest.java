package RealEstate.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import RealEstate.Pages.REAdminAddPost;
import RealEstate.Pages.REAdminAddTag;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class REAdminAddTagTest {
	static WebDriver driver;
	static REAdminAddPost login;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
		REAdminAddTag login = new REAdminAddTag(driver);
		driver.navigate().to("http://realty-real-estatem1.upskills.in/wp-admin/edit.php?post_type=property" );
		driver.manage().window().maximize();
	}
	// creating object of LoginPage class
	
	@Test
	public void SignIn()
	{
		REAdminAddTag login = new REAdminAddTag(driver);
		boolean success=login.AdminLogin("admin", "admin@123");
		AssertJUnit.assertEquals(success, true);
	}
	
	@Test
	public void Checkproperty()
	{
		REAdminAddTag login = new REAdminAddTag(driver);
		String curTitle= login.getRELoginTitle(driver);
		AssertJUnit.assertEquals(curTitle, "My Profile – Real Estate");		//Properties ‹ Real Estate — WordPress
	}
	
	@Test
	/*public void Property()
	{
		REAdminAddPost login = new REAdminAddPost(driver);
		boolean result=login.propertyEdit();
		AssertJUnit.assertEquals(result, true);
	}*/
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}


  
