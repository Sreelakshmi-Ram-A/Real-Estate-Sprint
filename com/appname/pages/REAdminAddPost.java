package RealEstate.Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAddPost {
	WebDriver driver;	

	By HeaderText = By.id("menu-posts"); 
	By AddPost = By.xpath("//*[@id=\"menu-posts\"]/ul/li[3]/a"); 
	
	
	By title=By.cssSelector("#title");
	
	By description=By.id("content_ifr");
	
	By publish=By.id("publish");
	By updated=By.cssSelector("#message > p");


	//creating parameterized constructor to initialize WebDriver reference
	public REAdminAddPost(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			
			WebElement element = driver.findElement(AddPost );
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			found=driver.findElement(AddPost ).isDisplayed();
			
			
		}
		
		
		catch (NoSuchElementException e)
		{
			found=false;
			
		}
		
		return found;
		
	}	
	
	public boolean isUpdated()
	{
		boolean found=false;
		try {
			WebElement element = driver.findElement(updated);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			found=driver.findElement(updated).isDisplayed();
		}
		catch(Exception e)
		{
			found=false;
		}
		return found;
	}
	

		public boolean AdminLogin()
		{
		
			driver.findElement(HeaderText).click();
			driver.findElement(AddPost).click();
			driver.findElement(title).sendKeys("Hello World!");
			driver.findElement(description).sendKeys("Welcome to Real Estate");
		
			
			driver.findElement(publish).click();
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}


	}





	

