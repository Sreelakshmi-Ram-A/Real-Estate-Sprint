package RealEstate.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class REAdminDeleteProperty {

		WebDriver driver;	

		By username= By.id("user_login");

		By password = By.id("user_pass");
		By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input"); 

		By HeaderText = By.id("menu-posts-property"); 
		By AllPropertiesbutton = By.xpath("//*[@id=\"wpbody-content\"]/div[3]/h1 "); 
		By SearchText=By.cssSelector("#post-search-input");
		By SearchProperty=By.id("search-submit");
		
		By property=By.cssSelector("#post-12216 > td.title.column-title.has-row-actions.column-primary.page-title > strong > a"); 
		By MoveToTrash=By.linkText("Move to Trash");
		By updated=By.cssSelector("#message > p");

		//creating parameterized constructor to initialize WebDriver reference
		public REAdminDeleteProperty (WebDriver driver)
		{
			this.driver =driver;
		}

		public boolean isHeaderFound()

		{
			
			boolean found=false;
			try {
				
				
				WebElement element = driver.findElement(AllPropertiesbutton);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				//Dashboard header present in page?
				found=driver.findElement(AllPropertiesbutton ).isDisplayed();
						
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

			public boolean AdminLogin(String un,String pw) throws InterruptedException
			{
				WebElement element = driver.findElement(username);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				driver.findElement(username).sendKeys(un);
				driver.findElement(password).sendKeys(pw);
				driver.findElement(SignInbutton).click();
				
				driver.findElement(HeaderText).click();
				driver.findElement(AllPropertiesbutton ).click();
				
				
				//driver.findElement(By.xpath("//*[@id=\"the-list\"]//tr[4]")).click();
				//driver.findElement(By.linkText("Trash")).click();
				
				
				driver.findElement(SearchText).sendKeys("Hi Lucky");
				driver.findElement(SearchProperty).click();
				
				
				driver.findElement(AllPropertiesbutton).click();
				
				driver.findElement(property).click();
				
				driver.findElement(MoveToTrash).click();
				driver.findElement(AllPropertiesbutton).click();
				driver.findElement(SearchText).sendKeys("Hi Lucky");
				driver.findElement(SearchProperty).click();
				
				
			
				boolean success=this.isHeaderFound();
				
				return success;
			
			
				
			}
			
			public boolean property(String pro)
			{
				driver.findElement(AllPropertiesbutton).click();
				
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
