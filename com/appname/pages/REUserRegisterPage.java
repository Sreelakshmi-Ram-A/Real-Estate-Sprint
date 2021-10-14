package com.appname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REUserRegisterPage {

	WebDriver driver;	

	By email= By.id("email");
	By firstname = By.id("first-name");	
	By lastname = By.id("last-name");	
	By Registernbutton = By.cssSelector("#signupform > p.signup-submit > input");
	By RegSuccess = By.cssSelector("#post-133 > div > div > div > div.notification.success.closeable");
	By Click=By.xpath("//*[@id=\"post-133\"]/div/div/div/ul/li[2]/a");
	//creating parameterized constructor to initialize WebDriver reference
	public REUserRegisterPage(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isSuccessMesgFound()

	{
		
		boolean found=false;
		try {
			
			WebElement element = driver.findElement(RegSuccess);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(RegSuccess).isDisplayed();
		}
		
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
		
	}	
		

		public boolean UserRegister(String em,String fn,String ln)
		{
			driver.findElement(Click).click();
			WebElement element = driver.findElement(email);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			driver.findElement(email).sendKeys(em);
			driver.findElement(firstname).sendKeys(fn);
			driver.findElement(lastname).sendKeys(ln);
			driver.findElement(Registernbutton).click();
			
			boolean success=this.isSuccessMesgFound();
			
			return success;
			
		
		}

		public String getRERegisterTitle(WebDriver driver) {
			// TODO Auto-generated method stub
			
			System.out.println(driver.getTitle());
			String curTitle = driver.getTitle();
			return curTitle;
			
			
		}
}
