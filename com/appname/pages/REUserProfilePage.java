package com.appname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
public class REUserProfilePage {
	WebDriver driver;	
	//By fname=By.id("first-name");
	//By lname=By.id("last-name");
	By title=By.id("agent_title");
	By phone=By.id("phone");
	//By email=By.id("email");
	By about=By.cssSelector("#description");
	By tw=By.id("twitter");
	By fb=By.id("facebook");
	By gp=By.id("gplus");
	By ld=By.id("linkedin");
	By sub=By.cssSelector("#edit_user > button");
	By Updated=By.xpath("//*[@id=\"post-133\"]/div[2]/div/div[1]/div/p");
	public REUserProfilePage(WebDriver driver)
	{
		this.driver =driver;
	}
	public boolean isHeaderFound() 

	{
		
		boolean found=false;
		try {
			
			WebElement element = driver.findElement(Updated);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//User profile updated?
			found=driver.findElement(Updated).isDisplayed();
			
		
		}
		
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
		
	}	
	public boolean UserUpdate() 
	{
		
		//driver.findElement(fname).clear();
		//driver.findElement(fname).sendKeys("Swathi");
		//driver.findElement(lname).clear();
		//driver.findElement(lname).sendKeys("M");
		driver.findElement(title).clear();
		driver.findElement(title).sendKeys("Buyer");
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys("9874524156");
		//driver.findElement(email).clear();
		//driver.findElement(email).sendKeys("sm@gmail.com");
		driver.findElement(about).clear();
		driver.findElement(about).sendKeys("Student");
		driver.findElement(tw).clear();
		driver.findElement(tw).sendKeys("twitter.com");
		driver.findElement(fb).clear();
		driver.findElement(fb).sendKeys("facebook.com");
		driver.findElement(gp).clear();
		driver.findElement(gp).sendKeys("google.com");
		driver.findElement(ld).clear();
		driver.findElement(ld).sendKeys("linkedin.com");
		driver.findElement(sub).click();
		
		 boolean success=this.isHeaderFound();
		 return success;
		
	}
	
}
