package onlineStore.onlineStore.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutCartPage {

	private WebDriver driver=null;

	public CheckOutCartPage(WebDriver driver){
		this.driver=driver;	
	}



	private WebElement getTableCheckOutCart(){
		String tableCheckOut=".//table[@class='checkout_cart']";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tableCheckOut)));

	}

	public  WebElement getRowFromCheckOutTable(String item){
		return (getTableCheckOutCart()).findElement(By.xpath("//*[text()='"+item+"']/../.."));
	}
	

	public  WebElement getStatusCartAct(){
		return driver.findElement(By.xpath(".//li[@class='cart act']"));
	}


	
	
	
	public  WebElement getInputQuantityFromCheckOutTable(String item){
		return (getRowFromCheckOutTable(item)).findElement(By.xpath("//td[starts-with(@class,'wpsc_product_quantity')]//input[@name='quantity']"));
	}

	public  WebElement getPriceFromCheckOutTable(String item){
		return (getRowFromCheckOutTable(item)).findElement(By.xpath("//td[starts-with(@class,'wpsc_product_price wpsc_product_price')]//span[@class='pricedisplay']"));
	}





	public WebElement getContinueCheckOut(){
		String continueCheckOut=".//*[@id='checkout_page_container']//span[text()='Continue']";
		return driver.findElement(By.xpath(continueCheckOut));

	}
	
	public WebElement getBtnRemove(){
		String remove=".//*[@id='checkout_page_container']//input[@value='Remove']";
		return driver.findElement(By.xpath(remove));
	}
	
	public List<WebElement> getAllBtnRemove(){
		String remove=".//*[@id='checkout_page_container']//input[@value='Remove']";
		return driver.findElements(By.xpath(remove));
	}






}
