package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener, ISuiteListener{


	public void onTestStart(ITestResult result) {  
		System.out.println("testng1.xml");
		System.out.println("testng2.xml");
		// TODO Auto-generated method stub  
		System.out.println("test cases started : "+result.getName());
	}  

	public void onTestSuccess(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Success of test cases and its details are : "+result.getName());  
	}  

	public void onTestFailure(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  

	public void onTestSkipped(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  

	public void onStart(ITestContext context) {  
		// TODO Auto-generated method stub  
		System.out.println("Start of test cases and its details are : "+context.getName());
	}  

	public void onFinish(ITestContext context) {  
		// TODO Auto-generated method stub  
		System.out.println("Finish of test cases and its details are : "+context.getName());
	}   

	public void onStart(ISuite context) {  
		// TODO Auto-generated method stub
		System.out.println("Start of test cases and its details are : "+context.getName());
	}  

	public void onFinish(ISuite context) {  
		// TODO Auto-generated method stub  
		System.out.println("Finish of test cases and its details are : "+context.getName());
	}
}  




