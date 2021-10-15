package com.appname.pages;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class REAdminHeaderPage {

	WebDriver driver;
	By HeaderText = By.cssSelector("head > title");
	public REAdminHeaderPage(WebDriver driver)
	{
		this.driver =driver;
	}

	
	public boolean checkHeadingBegining() {
		// TODO Auto-generated method stub
		String exampleString = driver.findElement(HeaderText).getText();
		System.out.println("\n"+exampleString);
		// String begins with M
		Pattern p = Pattern.compile("^D.*");
		java.util.regex.Matcher d = p.matcher(exampleString);
		boolean b = d.matches();
		System.out.println("String begins with D is "+b);
		return true;
	}
	
	
	
}
