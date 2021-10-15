package GFunction;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TakeScreenshot {

	//@Test

    //public void TakeScreenShot() throws Exception{
     public static void main(String[] args) throws Exception {
     	WebDriver driver ;
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sreelakshmi Ram.A\\Documents\\chromedriver_win32\\chromedriver.exe");
    	driver=new ChromeDriver();
        //goto url
         driver.get("https://the-internet.herokuapp.com/broken_images");
        
         
       //get current date and time 
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM"
         		+ "ddHHmmss");  
         LocalDateTime now = LocalDateTime.now();  
         System.out.println(dtf.format(now));  
         
         String brokenimagesfilename=("herokuapp_brokenImages"+dtf.format(now)+ ".jpg");
         String loginfailedfilename=("herokuapp_loginfail"+dtf.format(now)+".jpg");
         
         System.out.println(brokenimagesfilename);
         System.out.println(loginfailedfilename);
         
         //Call take screenshot user defined function for broken image page
          takeSnapShot(driver, brokenimagesfilename);
          
          //Call take screenshot user defined function for login 
          
          driver.navigate().to("https://the-internet.herokuapp.com/login");
          driver.findElement(By.id("username")).sendKeys("abcd");
          driver.findElement(By.id("password")).sendKeys("efgh");
          
          //click login button
          driver.findElement(By.cssSelector(".fa")).click();
          
          try {
        	  driver.findElement(By.xpath("//div[contains(text(),'invalid')]"));
        	  
        	   //JavascriptExecutor js = (JavascriptExecutor) driver;
        	   // js.executeScript("document.getElementByXpath('//div[contains(text(),'invalid')]'.setAttribute('border', '10')");
        	  WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'invalid')]"));
        	
        	  //Javascript command to highlight the error message in the page
        	  
        	JavascriptExecutor js = (JavascriptExecutor)driver;
        	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",ele);
 
        	takeSnapShot(driver, loginfailedfilename);
          
          }
          catch(NoSuchElementException e)
          {
        	  
        	    //No screenshot required if correct login happens
          }
          
          
          driver.close();
    }
    /**
     * This function will take screenshot
     * @param webdriver
     * @param fileWithPath
     * @throws Exception     *      */
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
         File DestFile=new File(fileWithPath);
      //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
