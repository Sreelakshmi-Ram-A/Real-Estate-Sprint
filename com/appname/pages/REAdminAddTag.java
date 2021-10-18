package RealEstate.Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAddTag {
	WebDriver driver;	


	By HeaderText = By.id("menu-posts"); 
	By Tag = By.xpath("//*[@id=\"menu-posts\"]/ul/li[5]/a");
	
	By titletag=By.id("tag-name");
	By slug=By.id("tag-slug");
	By Addtag=By.id("submit");
	
	By SearchText=By.cssSelector("#tag-search-input");
	By SearchButton=By.id("search-submit");
	


	//creating parameterized constructor to initialize WebDriver reference
	public REAdminAddTag(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			WebElement element = driver.findElement(Tag);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			found=driver.findElement(Tag).isDisplayed();
			
			
		}
		
		
		catch (NoSuchElementException e)
		{
			found=false;
			
		}
		
		return found;
		
	}	

		public boolean AdminLogin()
		{
			driver.findElement(HeaderText).click();
			driver.findElement(Tag).click();
			driver.findElement(titletag).sendKeys("House");
			driver.findElement(slug).sendKeys("estate");
		
			
			driver.findElement(Addtag).click();
			
			driver.findElement(SearchText).sendKeys("House");
			driver.findElement(SearchButton).click();
			
			
			
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		

	}





	

