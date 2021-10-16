package RealEstate.Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAllPost {
	WebDriver driver;	

	By username= By.id("user_login");

	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input"); 

	By HeaderText = By.id("menu-posts"); 
	By AllPost = By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a"); 
	By SearchText=By.cssSelector("#post-search-input");
	By SearchButton=By.id("search-submit");
	By post=By.cssSelector("#post-12118 > td.title.column-title.has-row-actions.column-primary.page-title > strong > a");
	By edit=By.cssSelector("#title");
	
	
	By update=By.id("publish");
	


	By updated=By.cssSelector("#message > p");

	//creating parameterized constructor to initialize WebDriver reference
	public REAdminAllPost(WebDriver driver)
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
			
			WebElement element = driver.findElement(AllPost);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(AllPost).isDisplayed();
			
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

		public boolean AdminLogin(String un,String pw)
		{
			WebElement element = driver.findElement(username);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			driver.findElement(username).sendKeys(un);
			driver.findElement(password).sendKeys(pw);
			driver.findElement(SignInbutton).click();
			
			driver.findElement(HeaderText).click();
			driver.findElement(AllPost).click();
			
			driver.findElement(SearchText).sendKeys("Hello World");
			driver.findElement(SearchButton).click();
			
			driver.findElement(AllPost).click();
			
			driver.findElement(post).click();
			driver.findElement(By.id("title")).clear();
			driver.findElement(edit).sendKeys("Hello!");
		
			driver.findElement(update).click();
		
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		
		public boolean property(String pro)
		{
			driver.findElement(AllPost).click();
			
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





	

