package TestCompponenet;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class irtryListner implements IRetryAnalyzer {
      
	int count=0;
	int maxtry=1;
	@Override
	public boolean retry(ITestResult result) {
System.out.println("rtry Listner");
		if(count<maxtry)
		{
			count++;
			return true;
		}
		return false;
	}

}
