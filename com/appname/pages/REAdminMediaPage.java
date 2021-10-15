package pages;

//import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class REAdminMediaPage {

	WebDriver driver;
	By media=By.xpath("//*[@id=\"menu-media\"]/a/div[3]");//
	By lib=By.xpath("//*[@id=\"menu-media\"]/ul/li[2]/a");
	By search=By.id("media-search-input");
	By smsg=By.xpath("//*[@id=\"wpbody-content\"]/div[3]/span");
	By update=By.id("publish");
	By delmsg=By.cssSelector("#message > p");
	By upmsg=By.xpath("//*[@id=\"message\"]/p");
	By vmsg=By.cssSelector("#titlebar > div > div > div > h2");
	
	public REAdminMediaPage(WebDriver driver)
	{
		this.driver =driver;
	}
	public boolean check(By msg)
	{
		boolean res=false;
	    try {
		WebElement element = driver.findElement(msg);
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		//updated 
		res=driver.findElement(msg).isDisplayed();
	}
	catch(Exception e)
	{
		return res;
	}
	return res;
	}
	/*
	public boolean search()
	{
		driver.findElement(media).click();
		driver.findElement(lib).click();
		driver.findElement(search).sendKeys("tiger");			
		driver.findElement(search).sendKeys(Keys.ENTER);			
		boolean res=this.check(smsg);
		return res;
	}
	*/
	public boolean search(String name)
	{
		driver.findElement(media).click();
		driver.findElement(lib).click();
		driver.findElement(search).sendKeys(name);			
		driver.findElement(search).sendKeys(Keys.ENTER);			
		boolean res=this.check(smsg);
		return res;
	}
	public boolean edit()
	{
		driver.findElement(lib).click();
		//driver.findElement(By.className("view-list")).click();
		driver.findElement(By.xpath("//*[@id=\"the-list\"]//tr[3]")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("Sweet home");
		driver.findElement(By.id("attachment_caption")).clear();
		driver.findElement(By.id("attachment_caption")).sendKeys("small home");
		driver.findElement(By.id("attachment_alt")).clear();
		driver.findElement(By.id("attachment_alt")).sendKeys("Home");
		driver.findElement(By.id("attachment_content")).clear();
		driver.findElement(By.id("attachment_content")).sendKeys("This is beautiful house.");
		driver.findElement(update).click();
		boolean success=this.check(upmsg);
		return success;
	}
	public boolean delete() throws InterruptedException
	{
		driver.findElement(lib).click();
		driver.findElement(By.xpath("//*[@id=\"the-list\"]//tr[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Delete Permanently")).click();	
		Thread.sleep(1000);
		Alert al = driver.switchTo().alert();
	    // click on OK to accept with accept()
	    al.accept();
		boolean result=this.check(delmsg);
		return result;
	}

	public boolean view()
	{
		driver.findElement(lib).click();
		driver.findElement(By.xpath("//*[@id=\"the-list\"]//tr[3]")).click();
		driver.findElement(By.linkText("View")).click();
		boolean rs=this.check(vmsg);
		return rs;
	}
}
