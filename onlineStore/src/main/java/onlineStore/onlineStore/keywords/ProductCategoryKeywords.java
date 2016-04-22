package onlineStore.onlineStore.keywords;

import onlineStore.onlineStore.ProductOrder;
import onlineStore.onlineStore.pageObjects.ProductCategory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductCategoryKeywords {

	WebDriver driver=null;
	ProductCategory productCategory=null;
	CheckOutCartKeywords checkOutCart=null;
	
	public ProductCategoryKeywords(WebDriver driver){

		productCategory=new ProductCategory(driver);
		checkOutCart=new CheckOutCartKeywords(driver);
		this.driver=driver;
	}




	public void addToCart(ProductOrder productOrder) throws Exception  {

		Actions action = new Actions(driver);

		action.clickAndHold(productCategory.getLinkProductCategoryMain()).click(productCategory.getLinkSpecificCategory(productOrder.getProductCategory())).build().perform();
		
		productCategory.getProductAddToCart(productOrder.getProductName()).click();

		productCategory.getBtnGoToCheckOut().click();
		
		checkOutCart.waitUntilStatusChangesCartArt();
		
	}
	
}
