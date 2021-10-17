package RealEstate.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REadminUser {
WebDriver driver;

By users=By.id("menu-users");
By alluser=By.xpath("//*[@id=\"menu-users\"]/ul/li[2]/a");
By search=By.id("user-search-input");
By btn=By.id("search-submit");
By text=By.className("subtitle");
By checkbox = By.id("user_847");
By changerole = By.id("new_role");
By change = By.id("changeit");
By role = By.xpath("//*[@id=\"new_role\"]/option[4]");
	public REadminUser(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public boolean isthere()
{
		boolean there=false;
		try {
			WebElement element = driver.findElement(text);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			there=driver.findElement(text).isDisplayed();
			there=true;
			return there;
		}catch(Exception e)
		{
			return there;
		}
		
}
	public boolean AllUser()
	{
		driver.findElement(users).click();
		driver.findElement(alluser).click();		
		driver.findElement(search).sendKeys("varshitha");
		driver.findElement(btn).click();
		driver.findElement(checkbox).click();
		driver.findElement(changerole).click();
		driver.findElement(role).click();
		driver.findElement(change).click();
		driver.findElement(alluser).click();		
		driver.findElement(search).sendKeys("varshitha");
		driver.findElement(btn).click();
		
		boolean res=this.isthere();
		return res;
	}
}
