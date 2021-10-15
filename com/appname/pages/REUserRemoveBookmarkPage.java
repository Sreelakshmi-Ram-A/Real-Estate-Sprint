package com.appname.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REUserRemoveBookmarkPage {
	WebDriver driver;	

	By bookmrk=By.xpath("//*[@id=\"post-133\"]/div[1]/div/div/ul[1]/li[3]/a");
	By property=By.cssSelector("#post-132 > div.col-md-8 > table > tbody > tr:nth-child(1) > th:nth-child(1)");
	By remove=By.xpath("//*[@id=\"post-132\"]/div[2]/table/tbody/tr[2]/td[2]/a");
	
	public REUserRemoveBookmarkPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			WebElement element = driver.findElement(property);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(property).isDisplayed();
		}
		
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
		
	}	
	
	
	public boolean Bookmark() throws InterruptedException
	{
		
		driver.findElement(bookmrk).click();
		Thread.sleep(1000);
		driver.findElement(remove).click();
		Thread.sleep(1000);
		boolean done=this.isHeaderFound();
		return done;	
	
	}
	
	
}
