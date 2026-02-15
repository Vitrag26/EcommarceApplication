package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponenets;

public class LandingPage extends AbstractComponenets {
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement usermail =driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement usermail;
	@FindBy(id="userPassword")
	WebElement password1;
	@FindBy(id="login")
	WebElement submit;
	
	
	public ProductCatelog  loginapplication(String email,String password)
	{
	 	usermail.sendKeys(email);
	    password1.sendKeys(password);
	    submit.click();
		ProductCatelog productCatelog=new ProductCatelog(driver);
		return productCatelog;

	} 
	
	public void geturl()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");		
	}
	
	
	
}
