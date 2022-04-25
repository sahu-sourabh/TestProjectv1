package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inetBanking.testCases.BaseTestClass;

public class ReportingListener extends BaseTestClass implements ITestListener {

	ExtentReports extentReports;
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
//		Before  each test case
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " is Passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test Case: " + result.getName() + " is Failed. Screenshot taken.");
		extentTest.log(Status.FAIL, result.getThrowable());

//		add screenshot for failed test
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				"./Reports/Screenshots/" + result.getName() + "_" + ExtentSetup.getActualDate() + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(
				"./Screenshots/" + result.getName() + "_" + ExtentSetup.getActualDate() + ".png",
				"Test case failure screenshot.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
//		setUp method call
		extentReports = ExtentSetup.setUpExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
//		close Extent
		extentReports.flush();
	}

}