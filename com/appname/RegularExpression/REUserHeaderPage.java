package com.appname.pages;

import java.util.regex.Pattern;

import org.apache.xerces.impl.xs.identity.Selector.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class REUserHeaderPage {

	WebDriver driver;
	By HeaderText = By.cssSelector("#logo > h2 > a");
	public REUserHeaderPage(WebDriver driver)
	{
		this.driver =driver;
	}

	
	public boolean checkHeadingBegining() {
		// TODO Auto-generated method stub
		String exampleString = driver.findElement(HeaderText).getText();
		System.out.println("\n"+exampleString);
		// String begins with M
		Pattern p = Pattern.compile("^M.*");
		java.util.regex.Matcher m = p.matcher(exampleString);
		boolean b = m.matches();
		System.out.println("String begins with M is "+b);
		return true;
	}
	
	
	
}
