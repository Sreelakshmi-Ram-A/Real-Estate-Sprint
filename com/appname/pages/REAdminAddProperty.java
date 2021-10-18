package RealEstate.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class REAdminAddProperty {
	WebDriver driver;	

	By HeaderText = By.id("menu-posts-property"); 
	By AddPropertiesbutton = By.xpath("//*[@id=\"menu-posts-property\"]/ul/li[3]/a"); 	
	By title=By.cssSelector("#title");
	By des=By.id("mceu_35"); //content
	
	By publish=By.cssSelector("#publish");
	By updated=By.cssSelector("#message > p");
	
	

	//creating parameterized constructor to initialize WebDriver reference
	public REAdminAddProperty(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			
			
			WebElement element = driver.findElement(AddPropertiesbutton);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(AddPropertiesbutton).isDisplayed();
			
			
			
		}
		
		
		catch (NoSuchElementException e)
		{
			found=false;
			
		}
		
		return found;
		
	}	
	
	
	
	
	
		public boolean AdminLogin()throws InterruptedException 
		{
			
			driver.findElement(HeaderText).click();
			driver.findElement(AddPropertiesbutton).click();
			driver.findElement(title).sendKeys("Hello hello,here add a title");
			driver.findElement(des).sendKeys("Guys add a description here");
			driver.findElement(publish).click();
					
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		
		

		

	}
		
	

	
