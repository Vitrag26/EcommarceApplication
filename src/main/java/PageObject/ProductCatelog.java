package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.AbstractComponenets;

public class ProductCatelog extends AbstractComponenets {
	WebDriver driver;
	public ProductCatelog(WebDriver driver)
	{   super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement usermail =driver.findElement(By.id("userEmail"));
//	List<WebElement> products=driver.findElements(By.cssSelector("mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	By productBy=By.cssSelector(".mb-3");
	
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	
	By toastmsg=By.cssSelector("#toast-container");
	

	
	 
  public  List<WebElement> getproductlist()
  {
	 
	  waitforEllemnts(productBy);
	  return products;
  }
  
  public WebElement  getproductbyname(String productName)
  {
		System.out.println(productName);
		WebElement prod=getproductlist().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
		return prod;
  }
  public void addproducttocart(String productName) throws InterruptedException
  {
	  
	  WebElement prod=getproductbyname(productName);
	  prod.findElement(addtocart).click();
	//  waitforEllemntstodisappear(spinner);
	  
  }


	

	
	
}
