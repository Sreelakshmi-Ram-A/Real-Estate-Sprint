package RealEstate.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAddNewFeature {

	WebDriver driver;	

	By username= By.id("user_login");
	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input"); 

	By HeaderText = By.id("menu-posts-property"); 
	By AddFeaturesbutton = By.xpath("//*[@id=\"menu-posts-property\"]/ul/li[4]/a");
	By name=By.id("tag-name");
	By slug=By.id("tag-slug");
	By des=By.id("tag-description");
	By SubmitAddRegion=By.id("submit");
	
	By SearchText=By.cssSelector("#tag-search-input");
	By Searchfeature=By.id("search-submit");
	By feature=By.cssSelector("#tag-1826 > td.name.column-name.has-row-actions.column-primary > strong > a");
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
	
	public boolean isUpdated()
	{
		boolean found=false;
		try {
			WebElement element = driver.findElement(SubmitAddRegion);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			found=driver.findElement(SubmitAddRegion).isDisplayed();
		}
		catch(Exception e)
		{
			found=false;
		}
		return found;
	}
	
	
	public boolean propertyEdit()
    {
		driver.findElement(AddFeaturesbutton).click();
    	//driver.findElement(EditProperty).click();
		driver.findElement(name).sendKeys("hiiiiiii511");
		driver.findElement(SubmitAddRegion).click();
		boolean done=this.isUpdated();
		return done;
    }
	
	
		public boolean AdminLogin(String un,String pw)
		{
			WebElement element = driver.findElement(username);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			driver.findElement(username).sendKeys(un);
			driver.findElement(password).sendKeys(pw);
			driver.findElement(SignInbutton).click();
			driver.findElement(HeaderText).click();
			driver.findElement(AddFeaturesbutton).click();
			driver.findElement(name).sendKeys("5Bhk land");
			driver.findElement(slug).sendKeys("I will think about this later");
			driver.findElement(des).sendKeys("And there,its  description");
			driver.findElement(SubmitAddRegion).click();
			
			driver.findElement(SearchText).sendKeys("5Bhk land");
			driver.findElement(Searchfeature).click();
			driver.findElement(feature).click();
			driver.findElement(By.id("slug")).clear();
			driver.findElement(editslug).sendKeys("Don't know about it");
			driver.findElement(submitedit).click();
			
			driver.findElement(BackToCategories).click();
			
			
			
			
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		
		public boolean property(String pro)
		{
			driver.findElement(AddFeaturesbutton).click();
			boolean result=this.isHeaderFound();
			return result;
		}

		public String getRELoginTitle(WebDriver driver) {
			// TODO Auto-generated method stub
			
			System.out.println(driver.getTitle());
			String curTitle = driver.getTitle();
			return curTitle;
			
			
		}

	}
	
		
	




