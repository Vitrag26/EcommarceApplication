package PageObject;

import java.util.List;
import java.util.zip.CheckedOutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponenets;

public class cartPage extends AbstractComponenets {
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;

	
	public cartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public Boolean VerifiedProductDisplay(String productName)
	{
		Boolean Match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("chanrge"));
		return Match;
	}
	public Checkedoutpage goTocheckout() throws InterruptedException
	{
		
		checkoutele.click();
		return new Checkedoutpage(driver);		
	}
}
