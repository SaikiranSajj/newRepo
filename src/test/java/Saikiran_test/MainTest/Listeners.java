package Saikiran_test.MainTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Saikiran_test.testcomponent.Base_Test;
import utilities.ExtentReporterNg;

public class Listeners  implements ITestListener{
	 ExtentReports extent = ExtentReporterNg.getReportObject(); 
	 ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	
    
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        extentTest.set(test);   // thread-safe storage
		   
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().pass(result.getMethod().getMethodName() + " has passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    // 1️⃣ Log the exception in ExtentReports
	    extentTest.get().fail(result.getThrowable());

	    String path = null;
	    try {
	        // 2️⃣ Get the test instance that failed
	        Base_Test testInstance = (Base_Test) result.getInstance();

	        // 3️⃣ Take screenshot using that test instance
	        path = testInstance.getScreenShot(result.getMethod().getMethodName());

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    // 4️⃣ Attach screenshot to ExtentReports
	    
	        extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	    
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		 extent.flush();
	}

}
