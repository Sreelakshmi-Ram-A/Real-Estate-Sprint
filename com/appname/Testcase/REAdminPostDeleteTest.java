package RealEstate.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import RealEstate.Pages.REAdminAddPost;
import RealEstate.Pages.REAdminAddTag;
import RealEstate.Pages.REAdminPostDelete;
import RealEstate.Pages.REAdminAllPost;
import RealEstate.Pages.REAdminLogin;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class REAdminPostDeleteTest {
	static WebDriver driver;
	static REAdminPostDelete login;
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
		REAdminPostDelete login = REAdminPostDelete(driver);
		driver.navigate().to("http://realty-real-estatem1.upskills.in/wp-admin/edit.php?post_type=property" );
		driver.manage().window().maximize();
	}
	private REAdminPostDelete REAdminPostDelete(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
	// creating object of LoginPage class
	
	@Test
	public void SignIn() throws InterruptedException
	{
		REAdminLogin login = new REAdminLogin(driver);
		boolean success=login.AdminLogin("mohankrishna176@gmail.com", "Secret@123&&");
		AssertJUnit.assertEquals(success, true);
		REAdminPostDelete login1 = new REAdminPostDelete(driver);
		boolean success1=login1.AdminLogin();
		AssertJUnit.assertEquals(success1, true);
	}
			
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}  


  
