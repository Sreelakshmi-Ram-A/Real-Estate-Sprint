package RealEstate.Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAddPost {
	WebDriver driver;	

	By username= By.id("user_login");

	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input"); 

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
			
			/*WebElement element = driver.findElement(HeaderText);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(HeaderText).isDisplayed();*/
			
			WebElement element = driver.findElement(AddPost );
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(AddPost ).isDisplayed();
			
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
			driver.findElement(AddPost).click();
			driver.findElement(title).sendKeys("Hello World!");
			driver.findElement(description).sendKeys("Welcome to Real Estate");
		
			
			driver.findElement(publish).click();
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}
		
		public boolean property(String pro)
		{
			driver.findElement(AddPost).click();
			
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





	

