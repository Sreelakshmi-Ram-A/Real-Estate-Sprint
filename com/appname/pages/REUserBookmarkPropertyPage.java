package com.appname.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REUserBookmarkPropertyPage {

	WebDriver driver;	
	By RealEstate= By.cssSelector("#breadcrumbs > ul > li.home > span > a > span");
	By SearchBar=By.xpath("//*[@id=\"ajaxsearchlite1\"]/div");
	
	By BookMark1=By.xpath("//button[@class='widget-button save realteo-bookmark-it with-tip']");
	By BookMark2=By.xpath("//button[@class='widget-button save realteo-bookmark-it with-tip liked']");
	
	public REUserBookmarkPropertyPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public boolean isClicked() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		boolean found=true;
		try {
			WebElement element = driver.findElement(BookMark2);
			found=true;
		}
		catch(Exception e)
		{
			found=true;
		}
		
		Thread.sleep(1000);
		
		return found;
	}
	
	public boolean bookMark() throws InterruptedException
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
		
		WebElement bk1 = driver.findElement(BookMark1);
        bk1.click();
		boolean success=this.isClicked();
		System.out.println(success);
		return success;
	}
}
