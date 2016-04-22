package onlineStore.onlineStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsPage {
	
	private WebDriver driver=null;

	public DetailsPage(WebDriver driver){
		this.driver=driver;	
	}

	public WebElement getLinkSaveProfile(){
		return driver.findElement(By.xpath(".//input[@value='Save Profile']"));
	}
	 
	public WebElement getLinkYourDetails(){
		return driver.findElement(By.xpath(".//a[text()='Your Details']"));
	}
	

public  WebElement getTxtFirstName(){
		
	WebDriverWait wait = new WebDriverWait(driver, 15);
	return wait.until(ExpectedConditions.elementToBeClickable((By.id("wpsc_checkout_form_2"))));

		//return driver.findElement(By.id("wpsc_checkout_form_2"));

	}
	
	
	public  WebElement getTxtLastName(){

		return driver.findElement(By.id("wpsc_checkout_form_3"));

	}
	
	

	public  WebElement getTxtEmail(){

		return driver.findElement(By.id("wpsc_checkout_form_9"));

	}

	public  WebElement getTxtAddress(){

		return driver.findElement(By.id("wpsc_checkout_form_4"));

	}

	
	public  WebElement getTxtCity(){

		return driver.findElement(By.id("wpsc_checkout_form_5"));

	}


	public  WebElement getTxtBillingCountry(){

		return driver.findElement(By.id("wpsc_checkout_form_7"));

	}

	public  WebElement getTxtPostalCode(){

		return driver.findElement(By.id("wpsc_checkout_form_8"));

	}
	
	

	public   WebElement getTxtPhone(){

		return driver.findElement(By.id("wpsc_checkout_form_18"));

	}

	
	public   WebElement getCheckBoxShippingSameAsBilling(){
		return driver.findElement(By.id("shippingSameBilling"));

	}
	



	
}
