package com.appname.pages;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class REUserEnquiryPage {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM"
     		+ "ddHHmmss");  
     static LocalDateTime now = LocalDateTime.now(); 
	static String loginfailedfilename=("realestate_EnquiryFail"+dtf.format(now)+".jpg");
	WebDriver driver;	
	By RealEstate= By.cssSelector("#breadcrumbs > ul > li.home > span > a > span");
	By SearchBar=By.xpath("//*[@id=\"ajaxsearchlite1\"]/div");
	
	By Email=By.xpath("//input[@name='your-email']");
	By name=By.xpath("//input[@name='your-name']");		
	By sub=By.xpath("//input[@name='your-subject']");
	By mesg=By.xpath("//textarea[@name='your-message']");
	By send=By.xpath("//input[@type='submit']");
	By err=By.xpath("//*[@id=\"wpcf7-f4-o1\"]/form/div[2]");
	public REUserEnquiryPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public boolean isSent()
	{
		boolean found=false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		try {
			WebElement element = driver.findElement(err);
			
			found=driver.findElement(err).isDisplayed();
			Thread.sleep(2000);
			//js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",ele);	
			try {
				
				takeSnapShot(driver, loginfailedfilename);
				Thread.sleep(1000);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			found=false;
		}
		return found;
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
         File DestFile=new File(fileWithPath);
      //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
	
	
	public boolean goToSearch() throws InterruptedException
	{
		driver.findElement(RealEstate).click();
		WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search here for Properties..']"));
		search.sendKeys("house");
		Thread.sleep(2000);
		search.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
	    driver.switchTo().window((String) tabs.get(1));
		
		WebElement enquiry = driver.findElement(name);
		enquiry.sendKeys("Demo");
		driver.findElement(Email).sendKeys("Demo123@gmail.com");
		driver.findElement(sub).sendKeys("Interested");
		driver.findElement(mesg).sendKeys("rent details");
		driver.findElement(send).click();
		boolean success=this.isSent();
		return success;
	}
}
