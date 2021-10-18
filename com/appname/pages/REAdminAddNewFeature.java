package RealEstate.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAddNewFeature {

	WebDriver driver;	

	

	By HeaderText = By.id("menu-posts-property"); 
	By AddFeaturesbutton = By.xpath("//*[@id=\"menu-posts-property\"]/ul/li[4]/a");
	By name=By.id("tag-name");
	By slug=By.id("tag-slug");
	By des=By.id("tag-description");
	By SubmitAddRegion=By.id("submit");
	
	By SearchText=By.cssSelector("#tag-search-input");
	By Searchfeature=By.id("search-submit");
	By feature=By.cssSelector("#tag-1959 > td.name.column-name.has-row-actions.column-primary > strong > a");
	By editslug=By.id("slug");
	By submitedit=By.cssSelector("#edittag > div > input");
	
	By BackToCategories=By.cssSelector("#message > p:nth-child(2) > a");
	
	


	//creating parameterized constructor to initialize WebDriver reference
	public REAdminAddNewFeature(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			
			WebElement element = driver.findElement(AddFeaturesbutton);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(AddFeaturesbutton).isDisplayed();		
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
			driver.findElement(AddFeaturesbutton).click();
			driver.findElement(name).sendKeys("1Bhk land");
			driver.findElement(slug).sendKeys("I will think about this later");
			driver.findElement(des).sendKeys("And there,its  description");
			driver.findElement(SubmitAddRegion).click();
			
			driver.findElement(SearchText).sendKeys("1Bhk land");
			driver.findElement(Searchfeature).click();
			driver.findElement(feature).click();
			driver.findElement(By.id("slug")).clear();
			driver.findElement(editslug).sendKeys("Don't know about it");
			driver.findElement(submitedit).click();
			
			driver.findElement(BackToCategories).click();
			
			
			
			
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		
		

	}







		
	









		
	




