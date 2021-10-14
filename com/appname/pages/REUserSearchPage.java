package com.appname.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REUserSearchPage {

	WebDriver driver;	

	By RealEstate= By.cssSelector("#breadcrumbs > ul > li.home > span > a > span");
	By SearchBar=By.cssSelector("#ajaxsearchlite1 > div > div.proinput > form");
	By HouseRent=By.linkText("http://realty-real-estatem1.upskills.in/house-for-rent/");
	
	public REUserSearchPage(WebDriver driver)
	{
		this.driver =driver;
	}
			
	public boolean goToSearch() throws InterruptedException
	{
		driver.findElement(RealEstate).click();
		
		WebElement search=driver.findElement(By.xpath("//input[@placeholder='Search here for Properties..']"));
		search.sendKeys("house");
		Thread.sleep(1000);
		search.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		 
		return true;
	}
}
