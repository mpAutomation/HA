package onlineStore.onlineStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutInfoPage {
	
	private WebDriver driver=null;

	public CheckOutInfoPage(WebDriver driver){
		this.driver=driver;	
	}

	//.//*[@id='current_country']

	public  WebElement getSelectCountry() {
		//<input class="shipping_region text  wpsc-visitor-meta" data-wpsc-meta-key="shippingstate" title="shippingstate" type="text" placeholder="State/Province" value="" name="collected_data[15]">
		//String currentCountry="current_country";
		//String sel=".//*[@id='change_country']/input[@title='shippingstate']";
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//return wait.until(ExpectedConditions.elementToBeClickable((By.xpath(sel))));

		//WebElement select = 
		return driver.findElement(By.name("country"));
	   
		
		//return driver.findElement(By.id(currentCountry));
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		
		//return wait.until(ExpectedConditions.((By.id(currentCountry))));

	}
	
	public WebElement getSelectDiv(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-current_country"))));
	}
	
	
	public WebElement getBtnCalculate(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//form[@id='change_country']//input[@value='Calculate']")));
		//<input type="submit" name="wpsc_submit_zipcode" value="Calculate">	
		//#change_country > input[type="submit"]:nth-child(6)
	}
	

	public WebElement getFormCalculation(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//form[@id='change_country']")));
		//<input type="submit" name="wpsc_submit_zipcode" value="Calculate">	
		//#change_country > input[type="submit"]:nth-child(6)
	}
	
	

	public WebElement getTotalShipping(){
		String totalPriceShipping=	".//tr[@class='total_price total_shipping']//span[@class='pricedisplay']";
		return driver.findElement(By.xpath(totalPriceShipping));

	}


	public  WebElement getTotalTaxPrice(){
		String totalTax=	".//tr[@class='total_price total_tax']//span[@class='pricedisplay']";
		return driver.findElement(By.xpath(totalTax));

	}
	
	public  WebElement getStatusCartInfo(){
		return driver.findElement(By.xpath(".//li[@class='info act']"));
	}

	public  WebElement getTotalPriceItem(){
		String totalPrice=	".//tr[@class='total_price total_item']//span[@class='pricedisplay']";
		return driver.findElement(By.xpath(totalPrice));

	}

	public  WebElement getTotal(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		String totalPrice=	".//tr[@class='total_price']//span[@class='pricedisplay']";
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(totalPrice)));
		

	}

	public  WebElement getBtnPurchase(){
		String btnPurchase=".//*[@id='wpsc_shopping_cart_container']//input[@class='make_purchase wpsc_buy_button']";
		
		String purchaseForm="//*[@id='wpsc_shopping_cart_container']//form[@class='wpsc_checkout_forms']";
		return driver.findElement(By.xpath(purchaseForm));
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnPurchase)));
		//String btnPurchase=".//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input";
		//String btnPurchase="span(input[name='submit'])";
		//String btnPurchase=".//*[@id='wpsc_shopping_cart_container']//input[@value='submit_checkout']";
		//<input class="make_purchase wpsc_buy_button" type="submit" name="submit" value="Purchase">
		
		//<input type="submit" value="Purchase" name="submit" class="make_purchase wpsc_buy_button">
		//String btnPurchase=".//*[@id='wpsc_shopping_cart_container']//div[@class='input-button-buy']";
		//*[@id="wpsc_shopping_cart_container"]/form/div[4]/div/div/span/input
		//String btnPurchase=".//*[@id='wpsc_shopping_cart_container']//input[@class='make_purchase wpsc_buy_button/parent::form']";
		
		//find_element_by_xpath('//input[@class="submit-advs"]/parent::form').submit().
		
		//return driver.findElement(By.cssSelector(btnPurchase));
	//	new Actions(driver).click(ecrButton).perform();
	}
	
	

	
	
	



	
	
}
