package com.utilities;
import com.testcases.*;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustumListners extends Base implements ITestListener 
{
	@Override
	public void onTestFailure(ITestResult resutl)
	{
		System.out.println("Test failed");
		failed(resutl.getMethod().getMethodName());//it will capture the screenshot as per the method name 
	}
	
	
	
}
