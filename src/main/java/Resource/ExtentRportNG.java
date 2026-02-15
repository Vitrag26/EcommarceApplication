package Resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentRportNG {
	
	public static ExtentReports GetreportObject()
	{
		  String path=System.getProperty("user.dir")+"//Reports//index.html";
    	  ExtentSparkReporter report=new ExtentSparkReporter(path);
    	  report.config().setReportName("Automation Test Report");
    	  report.config().setDocumentTitle("Login");
    	  ExtentReports ext=new ExtentReports();
    	  
    	  ext.attachReporter(report);
    	  ext.setSystemInfo("Tester","Vitrag Jain");
    	  return ext;
	}

}
