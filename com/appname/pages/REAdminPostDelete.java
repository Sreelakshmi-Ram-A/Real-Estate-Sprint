package RealEstate.Pages;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class REAdminPostDelete {

		WebDriver driver;	


		By HeaderText = By.id("menu-posts"); 
		By AllPost = By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a"); 
		By SearchText=By.cssSelector("#post-search-input");
		By SearchButton=By.id("search-submit");
		By post=By.cssSelector("#post-12532 > td.title.column-title.has-row-actions.column-primary.page-title > strong > a");
		
		By MoveToTrash=By.linkText("Move to Trash");
		By updated=By.cssSelector("#message > p");

		public REAdminPostDelete(WebDriver driver)
		{
			this.driver =driver;
		}

		public boolean isHeaderFound()

		{
			
			boolean found=false;
			try {
				
				WebElement element = driver.findElement(AllPost);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
			
				found=driver.findElement(AllPost).isDisplayed();
				
				
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
				driver.findElement(AllPost).click();
				
				driver.findElement(post).click();
				driver.findElement(MoveToTrash).click();
				
				driver.findElement(AllPost).click();
				driver.findElement(SearchText).sendKeys("hello sanchari");
				driver.findElement(SearchButton).click();
				
				boolean success=this.isHeaderFound();
				
				return success;
				
			
			}
			

		}
