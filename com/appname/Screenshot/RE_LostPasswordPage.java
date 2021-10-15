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

public class RE_LostPasswordPage {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM"
     		+ "ddHHmmss");  
     static LocalDateTime now = LocalDateTime.now(); 
	static String loginfailedfilename=("realestate_LoginFail"+dtf.format(now)+".jpg");
	

	WebDriver driver;	

	By username= By.id("user_login");
	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input");
    By err=By.xpath("//div[@class='notification error closeable']");
	
	By LostPass= By.xpath("//*[@id=\"tab1\"]/form/p[4]/a");

	By emailIn=By.id("user_login");
	By send=By.xpath("//*[@id=\"lostpasswordform\"]/p[2]/input");
	By mesg=By.id("post-124");
	
	public RE_LostPasswordPage(WebDriver driver) {
		this.driver =driver;
	}
	
	public boolean isError()
	{
		boolean found=false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,250)", "");
		try {
			WebElement element = driver.findElement(err);
			System.out.println("in isError");
			found=driver.findElement(err).isDisplayed();
			System.out.println("in isError1");
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
	
	public boolean isMesgFound()

	{
		
		boolean found=false;
		try {
			
			WebElement element = driver.findElement(mesg);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
			found=driver.findElement(mesg).isDisplayed();
			
		}
		
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
		
	}
	
	public boolean LostPassword(String un,String pw) throws InterruptedException
	{
		WebElement ele = driver.findElement(username);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(SignInbutton).click();
		Thread.sleep(2000);
		boolean err=this.isError();
		
		driver.findElement(LostPass).click();
		WebElement element = driver.findElement(emailIn);
		driver.findElement(emailIn).sendKeys("Sree123@gmail.com");
		driver.findElement(send).click();		
		boolean check=this.isMesgFound();
		
		return check;
	}
}
