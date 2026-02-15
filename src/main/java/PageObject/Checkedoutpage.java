package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponenets;

public class Checkedoutpage extends AbstractComponenets {
WebDriver driver;
	public Checkedoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

		
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectcountry;

	
	@FindBy(css=".btnn.action__submit")
	WebElement submit;
	
	////button[contains(@class,\"ta-item\")])[2]
	//.btnn.action__submit
	
	By result=By.cssSelector(".ta-results");
	public void selectcountry(String country1)
	{
		//System.out.println(country1);
	//	Actions act=new Actions(driver);
	//	act.sendKeys(country,country1).build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", country);
		country.sendKeys(country1);
		
		waitforEllemnts(result);
	
		selectcountry.click();
	}
	
	public confirmationPage submitorder()
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
		submit.click();
	return	new confirmationPage(driver);
	}
	

}
