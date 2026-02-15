package TestCompponenet;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resource.ExtentRportNG;

public class Listner extends Basetest implements ITestListener {
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	ExtentReports extent=ExtentRportNG.GetreportObject();
	public void onTestStart(ITestResult result) {
        System.out.println("Started: " + result.getName());
      test=  extent.createTest(result.getMethod().getMethodName());
      extenttest.set(test);

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Passed: " + result.getName());
        extenttest.get().log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result) {
    extenttest.get().fail(result.getThrowable());
    	try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    String filepath = null;
	try {
		filepath = getscreenshot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 extenttest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
    	
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped: " + result.getName());
    }

    public void onStart(ITestContext context) {
        System.out.println("Execution Started");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Execution Finished");
        
        extent.flush();
    }
	
	

}
