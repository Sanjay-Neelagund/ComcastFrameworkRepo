package Com.Comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer{
	int count=1;
	int limit =5;
	public boolean retry(ITestResult result) {
		if(count<=limit) {
			count++;
			return true;
		}
		return false;
	}
	

}
