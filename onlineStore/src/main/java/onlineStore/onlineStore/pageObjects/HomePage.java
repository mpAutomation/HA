package onlineStore.onlineStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {


	WebDriver driver=null;

	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement lnk_MyAccount(){

		return driver.findElement(By.id("account"));

	}

	public  WebElement lnk_LogOut(){
		return  driver.findElement(By.xpath(".//*[@id='account_logout']/a"));
	}

	public  WebElement lnk_Cart(){ 	 return driver.findElement(By.xpath(".//*[@id='header_cart']/a"));

	}



	public WebElement getEntryContent(){
		String entryContent=".//div[@class='entry-content']";
		return driver.findElement(By.xpath(entryContent));

	}



}
