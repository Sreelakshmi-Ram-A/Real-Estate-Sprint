package RealEstate.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


 //This class will store all the locators and methods of Login page
 
public class REAdminLoginPage {
WebDriver driver;	

By username= By.id("user_login");

By password = By.id("user_pass");
By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input");

By HeaderText = By.cssSelector("#wpbody-content > div.wrap > h1");


//creating parameterized constructor to initialize WebDriver reference
public REAdminLoginPage(WebDriver driver)
{
	this.driver =driver;
}

public boolean isHeaderFound()

{
	
	boolean found=false;
	try {
		
		WebElement element = driver.findElement(HeaderText);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Dashboard header present in page?
		found=driver.findElement(HeaderText).isDisplayed();
	}
	
	catch (NoSuchElementException e)
	{
		found=false;
	}
	
	return found;
	
}	
	

	public boolean AdminLogin(String un,String pw)
	{
		WebElement element = driver.findElement(username);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(SignInbutton).click();
		
		boolean success=this.isHeaderFound();
		
		return success;
		
	
	}

	public String getRELoginTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		
		System.out.println(driver.getTitle());
		String curTitle = driver.getTitle();
		return curTitle;
			
	}

}
