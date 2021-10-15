package RealEstate.pages;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminAllPropertiesPage {

				WebDriver driver;	


				By HeaderText = By.id("menu-posts-property"); 
				By AllPropertiesbutton = By.xpath("//*[@id=\"wpbody-content\"]/div[3]/h1 "); 
				By SearchText=By.cssSelector("#post-search-input");
				By SearchProperty=By.id("search-submit");
				
				By property=By.cssSelector("#post-11736 > td.title.column-title.has-row-actions.column-primary.page-title > strong > a");  //#post-11833 > td.title.column-title.has-row-actions.column-primary.page-title > strong > a
				By edit=By.cssSelector("#title");
				By publish=By.id("publish");
				By updated=By.cssSelector("#message > p");
				

				//creating parameterized constructor to initialize WebDriver reference
				public REAdminAllPropertiesPage(WebDriver driver)
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

					public boolean AdminLogin() throws InterruptedException
					{
						
						driver.findElement(HeaderText).click();
						driver.findElement(AllPropertiesbutton ).click();
						
						
						driver.findElement(SearchText).sendKeys("asmita@123");
						driver.findElement(SearchProperty).click();
						
						driver.findElement(AllPropertiesbutton).click();
						
						driver.findElement(property).click();
						driver.findElement(By.id("title")).clear();
						driver.findElement(edit).sendKeys("yoyo@123");
						driver.findElement(publish).click();
						
					
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


	
	