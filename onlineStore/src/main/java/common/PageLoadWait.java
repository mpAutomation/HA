package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class PageLoadWait {

	WebDriver driver=null;

	public PageLoadWait(WebDriver driver){
		this.driver=driver;
	}

	public void waitForPageLoaded()
	{
		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() 
				{
			public Boolean apply(WebDriver driver)
			{
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
				};
				Wait<WebDriver> wait = new WebDriverWait(driver,30);
				try
				{
					wait.until(expectation);
				}
				catch(Throwable error)
				{
					Assert.assertEquals(false, true,"Timeout waiting for Page Load Request to complete.");
				}
	}



}
