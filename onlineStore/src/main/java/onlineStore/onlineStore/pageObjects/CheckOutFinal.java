package onlineStore.onlineStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutFinal {
	WebDriver driver=null;
	
	public CheckOutFinal(WebDriver driver){
		this.driver=driver;
	}
	
	public  WebElement getOrderStatus(){

		return driver.findElement(By.xpath(".//p[text()='Thank you, your purchase is pending. You will be sent an email once the order clears.']"));

	}

	public  WebElement getStatusCartFinal(){
		return driver.findElement(By.xpath(".//li[@class='final']"));
	}
	
	
	
}
