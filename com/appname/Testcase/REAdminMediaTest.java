package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.REAdminLoginPage;
import pages.REAdminMediaPage;
import pages.REregisterpage;


public class REAdminMediaTest {

	static WebDriver driver;
	//static REAdminma media;
	
	@DataProvider(name = "Auth")
	  public static Object[][] credentials() {

	        return new Object[][] { { "tiger" }};

	  }
	
	@BeforeTest
	public void veryfylogin()
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("http://realty-real-estatem1.upskills.in/wp-admin/upload.php");
		driver.manage().window().maximize();		
	}
	
	@Test
	public void SignIn()
	{
		REAdminLoginPage media = new REAdminLoginPage(driver);
		boolean success=media.AdminLogin("admin", "admin@123");
		Assert.assertEquals(success, true);
	}
	
	@Test(dataProvider="Auth")
	public void medialibrary(String name) throws InterruptedException
	{
		REAdminMediaPage media=new REAdminMediaPage(driver);
		boolean success=media.search(name);
		Assert.assertEquals(success, true);	
		boolean success2=media.edit();
		Assert.assertEquals(success2, true);
		//boolean success3=media.delete();
		//Assert.assertEquals(success3, true);
		boolean success4=media.view();
		Assert.assertEquals(success4, true);
	}
	/*		
	@Test
	public void medialibrary() throws InterruptedException
	{
		REAdminMediaPage media=new REAdminMediaPage(driver);
		boolean success=media.search();
		Assert.assertEquals(success, true);	
		boolean success2=media.edit();
		Assert.assertEquals(success2, true);
		//boolean success3=media.delete();
		//Assert.assertEquals(success3, true);
		boolean success4=media.view();
		Assert.assertEquals(success4, true);
		//driver.findElement(By.linkText("Edit Media")).click();
	}*/
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
