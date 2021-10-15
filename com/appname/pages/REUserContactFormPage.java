package com.appname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class REUserContactFormPage {
	
	WebDriver driver;
	
	//Contact Form fields
	By name=By.cssSelector("#wpcf7-f119-p134-o1 > form > div.row > div:nth-child(1) > div > span > input");
	By email=By.cssSelector("#wpcf7-f119-p134-o1 > form > div.row > div:nth-child(2) > div > span > input");
	By subject=By.cssSelector("#wpcf7-f119-p134-o1 > form > div.row > div.col-md-12 > div > span > input");
	By message=By.cssSelector("#wpcf7-f119-p134-o1 > form > div:nth-child(3) > span > textarea");
	By send=By.cssSelector("#wpcf7-f119-p134-o1 > form > p > input");
	By success=By.cssSelector("#wpcf7-f119-p134-o1 > form > div.wpcf7-response-output.wpcf7-display-none.wpcf7-mail-sent-ng");
	
	public REUserContactFormPage(WebDriver driver)
	{
		this.driver=driver;
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
	
	public boolean ContactForm(String n, String e, String a, String m)
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
			
			boolean success=this.isHeaderFound();
			return success;
	}
	
}
