package test;

import java.time.Duration;
import java.util.List;

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

import PageObject.LandingPage;


public class Submitordertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions optio=new ChromeOptions();
		optio.addArguments("--incognito");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		LandingPage landing=new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("avik0811@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jet@2015");
		driver.findElement(By.id("login")).click();
	

		List<WebElement> products=driver.findElements(By.cssSelector("mb-3"));
	
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
				
				driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
			
				Actions act=new Actions(driver);
				act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
				driver.findElement(By.xpath("(//button[contains(@class,\"ta-item\")])[2]")).click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
				driver.findElement(By.cssSelector(".btnn.action__submit")).click();
			String text=	driver.findElement(By.cssSelector(".hero-primary")).getText();
			
			org.testng.Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));
			driver.close();
				
				

		
		

	}

}
