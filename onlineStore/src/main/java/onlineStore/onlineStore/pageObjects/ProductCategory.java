package onlineStore.onlineStore.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCategory {

	WebDriver driver=null;
	
	public ProductCategory(WebDriver driver){
		this.driver=driver;
	}
	
	
	
	
	public WebElement getLinkProductCategoryMain()	
	{
		String productCategoryMain=".//*['#main-nav']/a[text()='Product Category']";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productCategoryMain)));
	}
	
	
	public WebElement getLinkSpecificCategory(String productCategory){
		return getLinkProductCategoryMain().findElement(By.xpath("//a[text()='"+productCategory+"']"));
		//String item=".//*['#main-nav']/a[text()='Product Category']//ul//li//a[text()='"+productCategory+"']";
		//String item=".//*['#main-nav']/a[text()='Product Category']/..//a[text()='iPhones']";
		//String prodCategory=".//a[text()='"+productCategory+"']";
		//return driver.findElement(By.xpath(item));
		//return driver.findElement(By.xpath(prodCategory));
		 
	}
	
	public  WebElement getProductAddToCart(String productToAdd){
		String  itemToAddToCart=".//*[@id='default_products_page_container']//a[text()='"+productToAdd+"']/../..//input[@value='Add To Cart']";
		 return driver.findElement(By.xpath(itemToAddToCart));
	
	}
	
	public  WebElement getBtnGoToCheckOut(){
		String checkOutButton=".//*[@id='fancy_notification_content']/a[text()='Go to Checkout']";
		return driver.findElement(By.xpath(checkOutButton));
	}
	
	
	
	
	

	

		
	
	
	
	
	/*
	.//table[@class='checkout_cart']//*[text()='Apple iPhone 4S 16GB SIM-Free - Black']/../..//td[starts-with(@class,'wpsc_product_price wpsc_product_price')]
	.//table[@class='checkout_cart']//*[text()='Apple iPhone 4S 16GB SIM-Free - Black']/../..//td[starts-with(@class,'wpsc_product_quantity')]//input[@name='quantity']

	.//table[@class='checkout_cart']//*[text()='Apple iPhone 4S 16GB SIM-Free - Black']/../..//td[starts-with(@class,'wpsc_product_price')]
	//span[@class='pricedisplay']
	.//table[@class='checkout_cart']//*[text()='Apple iPhone 4S 16GB SIM-Free - Black']/../..//td[starts-with(@class,'wpsc_product_quantity')]//span[@class='pricedisplay']
	.//table[@class='checkout_cart']//*[text()='Apple iPhone 4S 16GB SIM-Free - Black']/../..//td[starts-with(@class,'wpsc_product_quantity')]//input[@name='quantity']


	.//table[@class='checkout_cart']//*[text()='Apple iPhone 4S 16GB SIM-Free - Black']/../..//td[starts-with(@class,'wpsc_product_price wpsc_product_price')]//span[@class='pricedisplay']

*/


}
