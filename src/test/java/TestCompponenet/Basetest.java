package TestCompponenet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObject.LandingPage;

public class Basetest {
	
	public 	WebDriver driver;
	public LandingPage landing;
	public WebDriver intiliaziedriver() throws IOException
	{
		
//test gmail
		
		Properties prop=new Properties();
		
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resource//GlobalData.properties");
		prop.load(fs);
		String browsername=prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
		ChromeOptions optio=new ChromeOptions();
		optio.addArguments("--incognito");
		 driver =new ChromeDriver();

		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			 driver =new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			 driver =new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	

	public 	List<HashMap<String, String>>  getJsondatatomap(String Filepath) throws IOException
	
	{
	
	@SuppressWarnings("deprecation")
	String jsonfile=FileUtils.readFileToString(new File(Filepath));
	ObjectMapper mapper=new ObjectMapper();
	
	List<HashMap<String, String>> data=mapper.readValue(jsonfile,new TypeReference<List<HashMap<String, String>>>(){});
	
	return data;
	
	
	
	}
	
    public String getscreenshot(String testcasename,WebDriver driver) throws IOException
    {
  	  TakesScreenshot ts= (TakesScreenshot)driver;
  	File Source=  ts.getScreenshotAs(OutputType.FILE);
  	File file=new File(System.getProperty("user.dir")+"//reports" +testcasename+".png");
  	
  	FileUtils.copyFile(Source, file);
  	return System.getProperty("user.dir")+"//reports" +testcasename+".png";
  	  
    }


	@BeforeMethod(alwaysRun = true)
	public LandingPage launchapplication() throws IOException
	{
		 driver= intiliaziedriver();

			landing=new LandingPage(driver);
			landing.geturl();
			return landing;
		 
	}
	@AfterMethod(alwaysRun = true)
	public void teardown()
	{
		driver.close();
	}
}
