package onlineStore.onlineStore.keywords;

import org.openqa.selenium.WebDriver;

import onlineStore.onlineStore.pageObjects.HomePage;
import onlineStore.onlineStore.pageObjects.LogInPage;
import onlineStore.onlineStore.pageObjects.ProductCategory;

public class SignInKeywords {
	
	WebDriver driver=null;
	HomePage homePage=null;
	LogInPage loginPage=null;
	
	public SignInKeywords(WebDriver driver){
			homePage=new HomePage(driver);
			loginPage=new LogInPage(driver);
	}

	
	
	 public  void signIn(String uName, String uPassword) throws Exception{
		 
		   homePage.lnk_MyAccount().click();;
		  
		   loginPage.txtbx_UserName().sendKeys(uName);
		 
		   loginPage.txtbx_Password().sendKeys(uPassword);
		 
		   loginPage.lnk_LogIn().click();
		   
		   Thread.sleep(10000);
		   
		   try{
			   //do this, so tests can be skipped if there is a failure during @BeforeTest
			   homePage.lnk_LogOut();
		   }
		   catch (Exception e){
			   
			   throw new Exception("Not able to login successfully. Log out button was not found after entering valid credentials");
		   }
		  
		  
		 
		   }
	 
	 

}
