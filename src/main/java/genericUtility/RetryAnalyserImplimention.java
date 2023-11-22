package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this is an implementation class for IRetry interface of TestNG
 * @author 91991
 *
 */
public class RetryAnalyserImplimention implements IRetryAnalyzer {

	int count=0;
	int retrycount=3;
	public boolean retry(ITestResult result) {
		while(count<retrycount)
		{
			count++;
			return true;//retry,rerun the script
		}
		return false;//stop retrying
	}

}
