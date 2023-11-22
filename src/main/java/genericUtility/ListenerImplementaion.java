package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * this class provide the implementation to ITestListener interface of TestNG
 * @author 91991
 *
 */
public class ListenerImplementaion implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---test execution started----");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--test pass---");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--test fail----");
		System.out.println(result.getThrowable());
		WebDriverUtility wutil=new WebDriverUtility();
		genericMethodJava jutil=new genericMethodJava();
		String screenshot = methodName+jutil.getsystemdateinformate();
		
		try {
			wutil.takeScreenShots(BaseClass.sdriver, screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--test skip----");
		System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-----suite execution started----");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-----suite execution finished----");
	}

}
