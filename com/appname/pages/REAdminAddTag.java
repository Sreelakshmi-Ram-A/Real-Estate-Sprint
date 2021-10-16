package RealEstate.Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAddTag {
	WebDriver driver;	

	By username= By.id("user_login");

	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input"); 

	By HeaderText = By.id("menu-posts"); 
	By Tag = By.xpath("//*[@id=\"menu-posts\"]/ul/li[5]/a");
	
	By titletag=By.id("tag-name");
	By slug=By.id("tag-slug");
	By Addtag=By.id("submit");
	
	By SearchText=By.cssSelector("#tag-search-input");
	By SearchButton=By.id("search-submit");
	
	By updated=By.cssSelector("#message > p");


	//creating parameterized constructor to initialize WebDriver reference
	public REAdminAddTag(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			/*WebElement element = driver.findElement(HeaderText);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(HeaderText).isDisplayed();*/
			
			WebElement element = driver.findElement(Tag);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(Tag).isDisplayed();
			
			/*WebElement searchelement = driver.findElement(SearchProperty);
			JavascriptExecutor searchjs = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(SearchProperty).isDisplayed();*/
			
			
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
	
	
	/*public boolean propertyEdit()
    {
		driver.findElement(AddPost).click();
    	/*driver.findElement(EditProperty).click();
		driver.findElement(title).sendKeys("hiiiiiii511");
		driver.findElement(publish).click();
		boolean done=this.isUpdated();
		return done;
    }*/

		public boolean AdminLogin(String un,String pw)
		{
			WebElement element = driver.findElement(username);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			driver.findElement(username).sendKeys(un);
			driver.findElement(password).sendKeys(pw);
			driver.findElement(SignInbutton).click();
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
		
		public boolean property(String pro)
		{
			driver.findElement(Tag).click();
			
			/*driver.findElement(SearchProperty).click();
			driver.findElement(SearchProperty).sendKeys(pro);*/
			
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





	

