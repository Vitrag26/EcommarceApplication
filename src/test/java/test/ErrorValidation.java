package test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.zip.CheckedInputStream;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNGAntTask;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObject.Checkedoutpage;
import PageObject.LandingPage;
import PageObject.ProductCatelog;
import PageObject.cartPage;
import PageObject.confirmationPage;
import TestCompponenet.Basetest;
import TestCompponenet.irtryListner;
import abstractComponents.AbstractComponenets;

public class ErrorValidation extends Basetest{

          @Test(groups = {"Errorhandling"},retryAnalyzer=irtryListner.class)
		// TODO Auto-generated method stub
		public void SubmitOrder() throws IOException, InterruptedException
		{
        	
		String productName="ZARA COAT 3";	
		ProductCatelog productCatelog=	landing.loginapplication("testdgggd@dee.com","Jet@201q5");
				

	}
          @Test
          public void productvalidation() throws IOException, InterruptedException
  		{
        	  
        	  String path=System.getProperty("user.dir")+"//Reports//index.html";
        	  ExtentSparkReporter report=new ExtentSparkReporter(path);
        	  report.config().setReportName("Automation Test Report");
        	  report.config().setDocumentTitle("Login");
        	  ExtentReports extent=new ExtentReports();
        	  
        	  
          	
  		String productName="ZARA COAT 3";	
  		ProductCatelog productCatelog=	landing.loginapplication("avik0811@gmail.com","Jet@2015");
  		List<WebElement> products=productCatelog.getproductlist();
  		productCatelog.addproducttocart(productName);
  		//productCatelog.goToCartPage();
  		cartPage cartpage=productCatelog.goToCartPage();
  		Boolean Match=	cartpage.VerifiedProductDisplay("ZARA COAT 3ww");
  		
  			org.testng.Assert.assertTrue(Match);
  				
  		

  	}

          
          
}
