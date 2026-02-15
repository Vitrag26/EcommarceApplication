package abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.cartPage;





public class AbstractComponenets {
	
WebDriver driver;

public AbstractComponenets(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


@FindBy(css = "[routerlink*='cart']")
WebElement cartButton;
	public void waitforEllemnts(By findby)
	{
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforEllemntstodisappear(WebElement spinner) throws InterruptedException
	{
	Thread.sleep(1000);
//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1));
//wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	
	public cartPage goToCartPage() throws InterruptedException
	{
		System.out.println("cart in");
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cartButton);
		System.out.println("cart out");

		cartPage cartpage=new cartPage(driver);
		return cartpage;
	
	}
	


}
