package com.appname.pages;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class REUserContactFormPage {
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM"
     		+ "ddHHmmss");  
     static LocalDateTime now = LocalDateTime.now(); 
	static String contactfail=("realestate_contactfail"+dtf.format(now)+".jpg");
	
	WebDriver driver;
	
	//Contact Form fields
	By name=By.cssSelector("#wpcf7-f119-p134-o1 > form > div.row > div:nth-child(1) > div > span > input");
	By email=By.cssSelector("#wpcf7-f119-p134-o1 > form > div.row > div:nth-child(2) > div > span > input");
	By subject=By.cssSelector("#wpcf7-f119-p134-o1 > form > div.row > div.col-md-12 > div > span > input");
	By message=By.cssSelector("#wpcf7-f119-p134-o1 > form > div:nth-child(3) > span > textarea");
	By send=By.cssSelector("#wpcf7-f119-p134-o1 > form > p > input");
	By success=By.cssSelector("#wpcf7-f119-p134-o1 > form > div.wpcf7-response-output.wpcf7-display-none.wpcf7-mail-sent-ng");
	By err=By.xpath("//*[@id=\"wpcf7-f119-p134-o1\"]/form/div[4]");
	
	public REUserContactFormPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean isError()
	{
		boolean found=false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,250)", "");
		try {
			WebElement element = driver.findElement(err);
			 Actions action = new Actions(driver);

	          //Performing the mouse hover action on the target element.
	          action.moveToElement(element).perform();
			System.out.println("in isError");
			found=driver.findElement(err).isDisplayed();
			System.out.println("in isError1");
			Thread.sleep(2000);
			//js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",ele);	
			try {
				
				takeSnapShot(driver, contactfail);
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
	
	
	public boolean isHeaderFound()
	{
		boolean found=false;
		try {
			
			WebElement element = driver.findElement(success);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			found=driver.findElement(success).isDisplayed();
		}
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
	}
	
	public boolean ContactForm(String n, String e, String a, String m) throws InterruptedException
	{	
		
	        driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/ul/li[1]/span/a/span")).click();
	        WebElement flip= driver.findElement(By.xpath("//*[@id=\"post-170\"]/div[9]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[1]/div/h2/a"));		          		    
	        //Creating object of an Actions class
	        Actions action = new Actions(driver);	
	        //Performing the mouse hover action on the target element.
	        action.moveToElement(flip).perform();
	        driver.findElement(By.xpath("//*[@id=\"post-170\"]/div[9]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[2]/div/div/a")).click();
	        
	        //Providing details in contact page
			driver.findElement(name).sendKeys(n);
			driver.findElement(email).sendKeys(e);
			driver.findElement(subject).sendKeys(a);
			driver.findElement(message).sendKeys(m);
			driver.findElement(send).click();
			Thread.sleep(2000);
			boolean err=this.isError();
			
			boolean success=this.isHeaderFound();
			return success;
	}
	
}
