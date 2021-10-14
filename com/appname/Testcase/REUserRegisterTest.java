package com.appname.Testcase;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.appname.pages.REUserRegisterPage;
import com.appname.pages.REUserRegisterXML;

public class REUserRegisterTest {
	static WebDriver driver;
	static REUserRegisterPage reg;
	
	String xlFilePath = "Data.xlsx";
    String sheetName = "Sheet1";
    REUserRegisterXML eat = null;
	@BeforeTest
	public void verifyRegister()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://realty-real-estatem1.upskills.in/my-profile/?redirect_to=http://realty-real-estatem1.upskills.in/wp-admin/\r\n"
				+ "");
		driver.manage().window().maximize();
		
	}
	// creating object of LoginPage class
	@Test
	public void CheckTitle()
	{
		REUserRegisterPage reg = new REUserRegisterPage(driver);
		String curTitle= reg.getRERegisterTitle(driver);
		Assert.assertEquals(curTitle, "My Profile – Real Estate");	
		
	}
	@Test(dataProvider = "userData")
    public void Register(String email, String firstname, String lastname)
    {
		REUserRegisterPage login = new REUserRegisterPage(driver);
		boolean success=login.UserRegister(email,firstname,lastname);
		try {
			REUserRegisterTest.takeSnapShot(driver,"C:\\Users\\Sreelakshmi Ram.A\\eclipse-workspace\\PageObjectModel\\new1.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(success, true);
    }
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	
		//Convert web driver object to TakeScreenshot
				TakesScreenshot scrShot =((TakesScreenshot)webdriver);
				//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				//Move image file to new destination
				File DestFile=new File(fileWithPath);
	
	}
	
	@DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }
     
    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
    {
        Object[][] excelData = null;
        eat = new REUserRegisterXML(xlFilePath);
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);
                 
        excelData = new Object[rows-1][columns];
         
        for(int i=1; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
            }
             
        }
        return excelData;
    }
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
