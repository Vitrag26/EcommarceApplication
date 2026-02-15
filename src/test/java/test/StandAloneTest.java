package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.zip.CheckedInputStream;

import javax.xml.xpath.XPath;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNGAntTask;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.Checkedoutpage;
import PageObject.LandingPage;
import PageObject.ProductCatelog;
import PageObject.cartPage;
import PageObject.confirmationPage;
import TestCompponenet.Basetest;
import abstractComponents.AbstractComponenets;

public class StandAloneTest extends Basetest{

          @Test(dataProvider = "getdata",groups={"purchaseorder"})
		// TODO Auto-generated method stub
		public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException
		{
        	
			String productname="ZARA COAT 3";
		ProductCatelog productCatelog=	landing.loginapplication(input.get("email"),input.get("password"));
		List<WebElement> products=productCatelog.getproductlist();
		productCatelog.addproducttocart(input.get("productname"));
		//productCatelog.goToCartPage();
		cartPage cartpage=productCatelog.goToCartPage();
		//Boolean Match=	cartpage.VerifiedProductDisplay(productName);
		
		//	org.testng.Assert.assertTrue(Match);
			
	Checkedoutpage outpage=cartpage.goTocheckout();
	outpage.selectcountry("india");
	confirmationPage cf=outpage.submitorder();
				
		//		org.testng.Assert.assertTrue(Match);
				//driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
			
				
		String mesage=	cf.confirmationPage();
			
			org.testng.Assert.assertTrue( mesage.equalsIgnoreCase("Thankyou for the order."));

	}
          
          @DataProvider
          public Object[][] getdata() throws IOException
          {
        	  
        	  File file = new File("src/test/resources/Purchaseorder.json");
        	  System.out.println(file.getAbsolutePath());

        	//  System.out.println("Project Path = " + System.getProperty("user.dir"));
        	  List<HashMap<String, String>> data= getJsondatatomap("E:/New folder (2)/Workspace/SeleniumFrameworkDesgin/src/test/resources/Purchaseorder.json");
        	return  new Object[][] {{data.get(0)},{data.get(1)}};
          }
          


}
