package stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObject.Checkedoutpage;
import PageObject.LandingPage;
import PageObject.ProductCatelog;
import PageObject.cartPage;
import PageObject.confirmationPage;
import TestCompponenet.Basetest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImp extends Basetest{
	
	public LandingPage landingpage;
	public ProductCatelog productCatelog;
	public confirmationPage cf;
	@Given("i landed on on ecommarce website")
	public void  i_landed_on_on_ecommarce_website() throws IOException
	{
		landingpage=launchapplication();
	}
	
	 @Given ("^Logged in with username (.+) and password (.+)$")
	 
	 public void loggedin_username_and_password(String username,String password)
	 
	 {
			 productCatelog=	landing.loginapplication(username,password);
			
	 }
	   @When("^i add the product (.+) to cart$")
	   public void add_product_tocart(String productname) throws InterruptedException
	   {
		   System.out.println(productname);
			List<WebElement> products=productCatelog.getproductlist();
			productCatelog.addproducttocart(productname);
	   }
	   @When("^checkout (.+)  and submit order$")
	   
	   public void checkout_zara_coat_3and_submit_order() throws InterruptedException
	   {
	    
		cartPage cartpage=productCatelog.goToCartPage();
		Checkedoutpage outpage=cartpage.goTocheckout();
		outpage.selectcountry("india");
		 cf=outpage.submitorder();

	   }
	   
	   @Then("{string} message dis-played om page")
	   public void messaage_display_confirmationpage(String string)
	   {
			
		String mesage=	cf.confirmationPage();
			
			org.testng.Assert.assertTrue( mesage.equalsIgnoreCase(string));   
	   }
	   @Then("{string} message is displayed")
	   public void message_is_displayed(String string1) {
	       // Write code here that turns the phrase above into concrete actions
	      Assert.assertEquals(string1, "Thank you message");
	      driver.close();
	   }

}  


	