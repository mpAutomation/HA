package onlineStore.onlineStore.pageObjects;

import org.openqa.selenium.*;

public class LogInPage {


	WebDriver driver=null;

	public LogInPage(WebDriver driver){
		this.driver=driver;
	}


	public WebElement txtbx_UserName(){

		return driver.findElement(By.id("log"));

	}

	public WebElement txtbx_Password(){

		return driver.findElement(By.id("pwd"));

	}


	public  WebElement lnk_LogIn(){

		return driver.findElement(By.id("login"));


	}

}