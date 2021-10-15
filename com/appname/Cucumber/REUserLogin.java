package com.appname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REUserLoginPage {

	WebDriver driver;	

	By username= By.id("user_login");
	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input");
    By err=By.xpath("//*[contains(text(),'We don't have any users with that email address.')]");
	By HeaderText = By.cssSelector("#logo > h2 > a");


	//creating parameterized constructor to initialize WebDriver reference
	public REUserLoginPage(WebDriver driver)
	{
		this.driver =driver;
	}

	
	
	public boolean isHeaderFound()

	{
		
		boolean found=false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try {
			
			WebElement element = driver.findElement(HeaderText);
			
			found=driver.findElement(HeaderText).isDisplayed();
		}
		
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
		
	}	
	

		public boolean UserLogin(String un,String pw) throws InterruptedException
		{
			WebElement element = driver.findElement(username);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			boolean success=this.isHeaderFound();
			
			driver.findElement(username).sendKeys(un);
			driver.findElement(password).sendKeys(pw);
			driver.findElement(SignInbutton).click();
			Thread.sleep(2000);
			
			return success;
			
		
		}

		public String getRELoginTitle(WebDriver driver) {
			// TODO Auto-generated method stub
			
			System.out.println(driver.getTitle());
			String curTitle = driver.getTitle();
			return curTitle;
			
			
		}
}
