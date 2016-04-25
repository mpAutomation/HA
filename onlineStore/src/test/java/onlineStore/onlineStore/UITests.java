package onlineStore.onlineStore;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import onlineStore.onlineStore.keywords.ProductCategoryKeywords;
import onlineStore.onlineStore.keywords.CheckOutCartKeywords;
import onlineStore.onlineStore.keywords.SignInKeywords;
import onlineStore.onlineStore.keywords.YourDetailsKeywords;
import onlineStore.onlineStore.pageObjects.HomePage;




public class UITests {

	private  WebDriver driver = null;
	private  CustomerOrderInfo customerInfo=null;
	private SignInKeywords signInKeywords=null;

	@BeforeTest
	public void setUp() throws Exception{
			//this is just customer information that can be used for edits to the billing info/user profile  form
		customerInfo=new CustomerOrderInfo();
		customerInfo.setEmail("m@yahoo.com");
		customerInfo.setShippingCountry("USA");
		customerInfo.setFirstName("Name");
		customerInfo.setLastName("LasttName");
		customerInfo.setAddress("123 Address");
		customerInfo.setCity("Austin");
		customerInfo.setBillingCountry("United States");
		customerInfo.setPostalCode("78000");
		customerInfo.setPhone("555-555-5555");
		customerInfo.setShippingSameAsBiling(true);
	}
	
			
	@BeforeMethod
	public void startBrowserSession() throws Exception{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(common.TestEnvVars.URL);
		signInKeywords=new SignInKeywords(driver);
		signInKeywords.signIn( common.TestEnvVars.Username, common.TestEnvVars.Password);			
	}
	
	@Test
	public void emptyCart(){
		//Verify removing all items from your cart produces an empty cart message.
		CheckOutCartKeywords keywords= new CheckOutCartKeywords(driver);
		keywords.removeAllItemsInCart();
		keywords.validateEmptyCartMessage();
		
		
	}


	@Test
	public void updateProfile() throws Exception{
		/*Verify updating your account details is saved 
		and retrieved after logging out and back in using the My Account link
		*/
		YourDetailsKeywords details=new YourDetailsKeywords(driver);
		String originalName=customerInfo.getFirstName();
		System.out.println(originalName);
		customerInfo.setFirstName("Name"+RandomStringUtils.randomAlphabetic(3));
		String updatedName=customerInfo.getFirstName();
		System.out.println(updatedName);
		 details.updateYourAccount(customerInfo);		 
		 
		 new HomePage(driver).lnk_LogOut().click();
		
		 signInKeywords.signIn(common.TestEnvVars.Username, common.TestEnvVars.Password);
		 details.validateYourAccount(customerInfo);
		
	}
	
		
		
	

	@Test
	public void orderItem() throws Exception {
		/*Submit an order for an Apple iPhone4s 16GB SIM-Free – Black 
		 * (known issue with State drop-down, selecting Country is adequate) 
		 * and verify the Total Price: given is correct (assume shipping cost is correct based on your choice). 
		 * You may assume prices shown on product pages are the correct price.
		 */

		//initialize keywords
		ProductCategoryKeywords productCategoryKeywords=new ProductCategoryKeywords(driver);
		CheckOutCartKeywords checkOutCartKeywords=new CheckOutCartKeywords(driver);

		ProductOrder productOrder=new ProductOrder();
		productOrder.setProductCategory("iPhones");
		productOrder.setProductName("Apple iPhone 4S 16GB SIM-Free – Black");
		productOrder.setProductQuantity("1");
		productOrder.setProductPrice("$270.00");

		

		String expectedShipping="$12.00";
		String expectedTax="$0.00";

		productCategoryKeywords.addToCart(productOrder);
		
		checkOutCartKeywords.validateItemShoppingCartYourCart(productOrder);
		checkOutCartKeywords.checkOutYourCart();

		
		checkOutCartKeywords.validateTotals(customerInfo.getShippingCountry(),expectedShipping,productOrder.getProductPrice() ,expectedTax );
	
		checkOutCartKeywords.fillInCheckOutInfo(customerInfo);
				
		//TODO: THIS FINALM SUBMIT FAILS ON AND OFF, EVEN MANUALLY.
		checkOutCartKeywords.completePurchase(true);	
	}



	@AfterMethod(alwaysRun=true)
	public void closeSession()
	{
		driver.quit();
		driver = null;
		signInKeywords=null;

		
	}

}
