package RealEstate.pages;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class REAddNewUser {
	WebDriver driver;

	//By users=By.id("menu-users");

	By username= By.id("user_login");

	By password = By.id("user_pass");
	By SignInbutton = By.cssSelector("#tab1 > form > p:nth-child(3) > input"); 
	
	By HeaderText = By.cssSelector("#menu-users > a > div.wp-menu-name");
	By AddNew = By.xpath("//*[@id=\"menu-users\"]/ul/li[3]/a");
	
	By Username = By.xpath("//*[@id=\"user_login\"]");
	By Email = By.cssSelector("#email");
	By FirstName = By.id("first_name");
	By LastName = By.id("last_name");
	By Website = By.id("url");
	By Password = By.id("pass1-text");
	By ShowPassword = By.xpath("//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button");
	By Cancel = By.cssSelector("#createuser > table > tbody > tr.form-field.form-required.user-pass1-wrap > td > div > button.button.wp-cancel-pw.hide-if-no-js > span");
	By PasswordInput = By.id("pass1-text");
	By AddNewUser = By.id("createusersub");
	
	By text = By.cssSelector("#message > p");
	public REAddNewUser(WebDriver driver)
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
			
			WebElement element = driver.findElement(HeaderText);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			/*found=driver.findElement(AllPropertiesbutton ).isDisplayed();
			
			WebElement searchelement = driver.findElement(SearchProperty);
			JavascriptExecutor searchjs = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(SearchProperty).isDisplayed();*/
			found=driver.findElement(HeaderText).isDisplayed();
			
			
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
			WebElement element = driver.findElement(text);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			found=driver.findElement(text).isDisplayed();
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
				driver.findElement(AddNew).click();		
				driver.findElement(Username).sendKeys("kjkjk");
				driver.findElement(Email).sendKeys("knkn@gmail.com");
				driver.findElement(FirstName).sendKeys("jgjj");
				driver.findElement(LastName).sendKeys("ghgh");
				driver.findElement(Website).sendKeys("Newusr");
				driver.findElement(ShowPassword).click();
				driver.findElement(Cancel).click();
				driver.findElement(ShowPassword).click();
				driver.findElement(PasswordInput).sendKeys("Heymama@543");
				driver.findElement(AddNewUser).click();
				
				
				boolean Update=this.isUpdated();
				boolean success=this.isHeaderFound();
				
				return Update;
				
				//public boolean property(String pro)
				//{
					//driver.findElement(AllPropertiesbutton).click();
					
					/*driver.findElement(SearchProperty).click();
					driver.findElement(SearchProperty).sendKeys(pro);
					
					boolean result=this.isHeaderFound();
					return result;
				}

				public String getRELoginTitle(WebDriver driver) {
					// TODO Auto-generated method stub
					
					System.out.println(driver.getTitle());
					String curTitle = driver.getTitle();
					return curTitle;*/
					
}
}