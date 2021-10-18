package RealEstate.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAddNewRegion {

	WebDriver driver;	

	By HeaderText = By.id("menu-posts-property"); 
	By AddRegionsbutton = By.xpath("//*[@id=\"menu-posts-property\"]/ul/li[5]/a"); 
	By name=By.id("tag-name");
	By slug=By.id("tag-slug");
	By des=By.id("tag-description");
	By SubmitAddRegion=By.id("submit");
	
	By SearchText=By.cssSelector("#tag-search-input");
	By Searchregion=By.id("search-submit");
	By region=By.cssSelector("#tag-1995 > td.name.column-name.has-row-actions.column-primary > strong > a");
	By editslug=By.id("slug");
	By submitedit=By.cssSelector("#edittag > div > input");
	
	By BackToCategories=By.cssSelector("#message > p:nth-child(2) > a");

	//creating parameterized constructor to initialize WebDriver reference
	public REAdminAddNewRegion(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			
			WebElement element = driver.findElement(AddRegionsbutton);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(AddRegionsbutton).isDisplayed();
				
		}
		
		
		catch (NoSuchElementException e)
		{
			found=false;
			
		}
		
		return found;
		
	}	
	
	


		public boolean AdminLogin() throws InterruptedException//String un,String pw)
		{
			
			driver.findElement(HeaderText).click();
			driver.findElement(AddRegionsbutton).click();
			driver.findElement(name).sendKeys("India");
			driver.findElement(slug).sendKeys("I dont know");
			driver.findElement(des).sendKeys("Hiiiiiiiiiiiiiiiiiiiiii i am the description");
			Thread.sleep(1000);
			driver.findElement(SubmitAddRegion).click();
			
			driver.findElement(SearchText).sendKeys("India");
			Thread.sleep(1000);
			driver.findElement(Searchregion).click();
			driver.findElement(region).click();
			driver.findElement(By.id("slug")).clear();
			driver.findElement(editslug).sendKeys("get lost");
			driver.findElement(submitedit).click();
			
			
			driver.findElement(BackToCategories).click();
			
		
			
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		
		

	}
	
		
	


