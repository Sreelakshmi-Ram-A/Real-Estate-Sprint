package RealEstate.Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAddCategories {
	WebDriver driver;	


	By HeaderText = By.id("menu-posts"); 
	By Category = By.xpath("//*[@id=\"menu-posts\"]/ul/li[4]/a");
	
	By titlecategory=By.id("tag-name");
	By slug=By.id("tag-slug");
	By Addcategory=By.id("submit");
	By SearchText=By.cssSelector("#tag-search-input");
	By SearchButton=By.id("search-submit");
	
	
	By updated=By.cssSelector("#message > p");


	//creating parameterized constructor to initialize WebDriver reference
	public REAdminAddCategories(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			
			WebElement element = driver.findElement(Category );
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
			found=driver.findElement(Category ).isDisplayed();
			
			
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
			driver.findElement(Category).click();
			driver.findElement(titlecategory).sendKeys("House");
			driver.findElement(slug).sendKeys("estate");
		
			
			driver.findElement(Addcategory).click();
			
			driver.findElement(SearchText).sendKeys("House");
			driver.findElement(SearchButton).click();
			
			
			
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		

	}





	

