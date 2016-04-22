package onlineStore.onlineStore.keywords;

import onlineStore.onlineStore.CustomerOrderInfo;
import onlineStore.onlineStore.pageObjects.DetailsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class YourDetailsKeywords {

	WebDriver driver=null;
	DetailsPage detailsPage=null;
	
	
	public YourDetailsKeywords(WebDriver driver){

		detailsPage=new DetailsPage(driver);
		this.driver=driver;
	}
	
	public void updateYourAccount(CustomerOrderInfo customerInfo){
		detailsPage.getLinkYourDetails().click();
		editBillingDetails(customerInfo);
		detailsPage.getLinkSaveProfile().click();
		
		
	}
	
	/*
	public void submitPurchase(){
		detailsPage.getTxtPhone().sendKeys(Keys.ENTER);
	}*/
	
	public void editEmailTxtField(String email){
		clearAndSetText(detailsPage.getTxtEmail(),email);
	}
	
	public void editBillingDetails(CustomerOrderInfo customerInfo){
		clearAndSetText(detailsPage.getTxtFirstName(),customerInfo.getFirstName());
		clearAndSetText(detailsPage.getTxtLastName(),customerInfo.getLastName());
		clearAndSetText(detailsPage.getTxtAddress(),customerInfo.getAddress());
		
		clearAndSetText(detailsPage.getTxtCity(),customerInfo.getCity());
		setListElement(detailsPage.getTxtBillingCountry(),customerInfo.getBillingCountry());
		clearAndSetText(detailsPage.getTxtPostalCode(),customerInfo.getPostalCode());
		
		if(!customerInfo.getShippingSameAsBiling()){
			Assert.assertEquals(true, false,"Automation not ready for shipping not same as billing");	
		}
		if(customerInfo.getShippingSameAsBiling()&&!detailsPage.getCheckBoxShippingSameAsBilling().isSelected()){
			
			Actions builder = new Actions(driver);   
			builder.moveToElement(detailsPage.getCheckBoxShippingSameAsBilling(), 2,2 ).click().build().perform();
			//detailsPage.getCheckBoxShippingSameAsBilling().click();
		}
		
		clearAndSetText(detailsPage.getTxtPhone(),customerInfo.getPhone());
		
		//detailsPage.getTxtPhone().click();
		
		
	}
	
	private void setListElement(WebElement list, String theOption){
	java.util.List<WebElement> options = list.findElements(By.tagName("option"));
    for(WebElement option : options){
        if(option.getText().equals(theOption)) {
            option.click();
            break;
        }
    }
	}
	
	public void validateYourAccount(CustomerOrderInfo customerInfo){
		detailsPage.getLinkYourDetails().click();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(detailsPage.getTxtFirstName(),customerInfo.getFirstName(),"Validating First Name");
		sa.assertEquals(detailsPage.getTxtLastName(),customerInfo.getLastName(),"Validating Last Name");
		sa.assertEquals(detailsPage.getTxtAddress(),customerInfo.getAddress(),"Validating address");
		sa.assertEquals(detailsPage.getTxtCity(),customerInfo.getCity(),"Validating city");
		sa.assertEquals(detailsPage.getTxtBillingCountry(),customerInfo.getBillingCountry(),"Validating city");
		sa.assertEquals(detailsPage.getTxtPostalCode(),customerInfo.getPostalCode(),"Validating postal Code");
		sa.assertEquals(detailsPage.getTxtPhone(),customerInfo.getPhone());
				
	}
	
	
	
	
	private void clearAndSetText(WebElement webElement, String textToSet){
		webElement.clear();
		
		webElement.sendKeys(Keys.DOWN+textToSet+Keys.UP);
		webElement.click();
	}

	
}
