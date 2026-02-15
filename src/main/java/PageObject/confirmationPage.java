package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponenets;

public class confirmationPage extends AbstractComponenets {
	
	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

		
	}
	@FindBy(css=".hero-primary")
	WebElement textmessage;
	public String  confirmationPage()
	{
		return	textmessage.getText();
		
		
			
	}

}
