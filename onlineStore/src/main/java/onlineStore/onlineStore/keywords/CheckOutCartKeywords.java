package onlineStore.onlineStore.keywords;

import java.util.List;

import onlineStore.onlineStore.CustomerOrderInfo;
import onlineStore.onlineStore.ProductOrder;
import onlineStore.onlineStore.pageObjects.CheckOutCartPage;
import onlineStore.onlineStore.pageObjects.CheckOutFinal;
import onlineStore.onlineStore.pageObjects.CheckOutInfoPage;
import onlineStore.onlineStore.pageObjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import common.PageLoadWait;

public class CheckOutCartKeywords {

	CheckOutCartPage checkOutCartPage=null;
	CheckOutInfoPage checkOutInfoPage=null;
	CheckOutFinal checkOutFinal=null;
	YourDetailsKeywords details=null;
	WebDriver driver=null;
	HomePage homePage=null;
	PageLoadWait pageLoad=null;

	public CheckOutCartKeywords(WebDriver driver){
		this.driver=driver;

		checkOutCartPage=new CheckOutCartPage(driver);
		checkOutInfoPage=new CheckOutInfoPage(driver);
		checkOutFinal=new CheckOutFinal(driver);
		details=new YourDetailsKeywords(driver);
		pageLoad=new PageLoadWait(driver);
		homePage=new HomePage(driver);

	}

	public void waitUntilStatusChangesFinal() throws Exception{
		String expectedRgba="rgba(0, 0, 0, 1)";
		for (int i=0;i<30;i++){
			if((!checkOutCartPage.getStatusCartAct().getCssValue("outline-color").contains(expectedRgba))){
				Thread.sleep(1000);
			}
			else{
				break;
			}

		}
	}

	public void waitUntilStatusChangesCartArt() throws Exception{
		String expectedRgba="rgba(0, 0, 0, 1)";
		for (int i=0;i<30;i++){
			if((!checkOutCartPage.getStatusCartAct().getCssValue("outline-color").contains(expectedRgba))){
				Thread.sleep(1000);
			}
			else{
				break;
			}

		}
	}

	public void waitUntilStatusChangesCartInfo() throws Exception{
		String expectedRgba="rgba(0, 0, 0, 1)";
		for (int i=0;i<30;i++){
			if((!checkOutCartPage.getStatusCartAct().getCssValue("outline-color").contains(expectedRgba))){
				Thread.sleep(1000);
			}
			else{
				break;
			}

		}
	}




	public  void validateItemShoppingCartYourCart(ProductOrder productOrder){

		SoftAssert sa=new SoftAssert();


		String productReplaceDash=productOrder.getProductName().replace("–", "-");

		WebElement elementQuantity=checkOutCartPage.getInputQuantityFromCheckOutTable(productReplaceDash);
		String actualQuantity=elementQuantity.getAttribute("value");

		WebElement elementPriceTl=checkOutCartPage.getPriceFromCheckOutTable(productReplaceDash);

		String actualPrice=elementPriceTl.getText();

		sa.assertEquals(actualQuantity.trim(), productOrder.getProductQuantity().trim(),"Validating the quantity of items in the shopping cart is correct");
		sa.assertEquals(actualPrice.trim(), productOrder.getProductPrice().trim(),"Validating the price of the item is correct");

		sa.assertAll();

	}




	public  void validateItemShoppingCartYourCart(String item, String expectedQuantity, String expectedPrice){

		SoftAssert sa=new SoftAssert();


		//this assertions happen if the products are found in the cart. Commonly done, so created in Keywords
		//get the price
		//get the quantity

		WebElement elementQuantity=checkOutCartPage.getInputQuantityFromCheckOutTable(item);
		String actualQuantity=elementQuantity.getAttribute("value");

		WebElement elementPriceTl=checkOutCartPage.getPriceFromCheckOutTable(item);

		String actualPrice=elementPriceTl.getText();

		sa.assertEquals(actualQuantity.trim(), expectedQuantity.trim(),"Validating the quantity of items in the shopping cart is correct");
		sa.assertEquals(actualPrice.trim(), expectedPrice.trim(),"Validating the price of the item is correct");

		sa.assertAll();

	}

	public void getMessageEmptyCart(){

	}

	public  void checkOutYourCart() throws Exception{
		checkOutCartPage.getContinueCheckOut().click();
		pageLoad.waitForPageLoaded();
		waitUntilStatusChangesCartInfo();
	}




	public void fillInCheckOutInfo(CustomerOrderInfo customerInfo) throws Exception{		
		details.editBillingDetails(customerInfo);
		details.editEmailTxtField(customerInfo.getEmail());
		pageLoad.waitForPageLoaded();
		waitUntilStatusChangesCartInfo();

	}



	public  void validateTotals(String shippingCountry,String expectedShipping, String expectedItemCost, String expectedTax) throws Exception{
		java.util.List<WebElement> options = checkOutInfoPage.getSelectCountry().findElements(By.tagName("option"));
		for(WebElement option : options){
			if(option.getText().equals(shippingCountry)) {
				option.click();
				break;
			}
		}

		waitUntilStatusChangesCartInfo();
		checkOutInfoPage.getFormCalculation().submit();


		pageLoad.waitForPageLoaded();
		waitUntilStatusChangesCartInfo();

		String actualTotalItem=checkOutInfoPage.getTotalPriceItem().getText().trim().replace("$", "");
		String actualTax=checkOutInfoPage.getTotalTaxPrice().getText().trim().replace("$", "");
		String actualShipping=checkOutInfoPage.getTotalShipping().getText().trim().replace("$","");
		String actualTotal=checkOutInfoPage.getTotal().getText().trim().replace("$", "");

		System.out.println("Totals: "+actualTotal);
		System.out.println("Tax: "+actualTax);
		System.out.println("Shipping: "+actualShipping);
		System.out.println("Total Item: "+actualTotalItem);

		System.out.println("EX ax: "+expectedTax);
		System.out.println("EXShipping: "+expectedShipping);
		System.out.println("EX Total Item: "+expectedItemCost);


		SoftAssert sa=new SoftAssert();



		sa.assertEquals(actualTax, expectedTax.trim().replace("$", ""),"Validating tax amount is ");

		sa.assertEquals(actualShipping, expectedShipping.trim().replace("$", ""),"Validating shipping");

		sa.assertEquals(actualTotalItem, expectedItemCost.trim().replace("$", ""),"Validating total item");



		Double actualTotalConv=Double.valueOf(actualTotal.replace("$", ""));

		Double.valueOf(actualTotalItem);
		Double.valueOf(actualShipping);
		Double.valueOf(actualTax);

		Double expectedTotalConv=Double.valueOf(actualTotalItem)+Double.valueOf(actualShipping)+Double.valueOf(actualTax);

		sa.assertEquals(actualTotalConv,expectedTotalConv, "Validating total amount");

		sa.assertAll();


	}

	public void removeAllItemsInCart(){

		homePage.lnk_Cart().click();
		List<WebElement> removeAll=checkOutCartPage.getAllBtnRemove();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		for(int i=0;i<removeAll.size();i++){
			//for(WebElement remove : removeAll){
			WebElement remove=checkOutCartPage.getBtnRemove();	
			wait.until(ExpectedConditions.elementToBeClickable(remove));
			remove.click();
		}

	}

	public void validateEmptyCartMessage(){
		String expectedTxt="Oops, there is nothing in your cart.";
		System.out.println(homePage.getEntryContent().getText());
		Assert.assertEquals(homePage.getEntryContent().getText(), expectedTxt,"Message after removing all items from cart ");


	}

	public void completePurchase(boolean validate) throws Exception{
		pageLoad.waitForPageLoaded();
		checkOutInfoPage.getBtnPurchase().submit();
		pageLoad.waitForPageLoaded();
		checkOutFinal.getOrderStatus();
	}








}
