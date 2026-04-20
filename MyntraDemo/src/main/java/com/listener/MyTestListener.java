package com.listener;

import org.testng.ITestListener;

import org.testng.ITestResult;


import com.myntra.base.Keyword;
import com.myntra.utils.Screenshot;


public  class MyTestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println("Test Failed: " + result.getName());
		String testName = result.getName();
		Screenshot.captureScreenshot(Keyword.driver, testName); //base class remove keywordclass*
	}
//	@Override
//	public void onTestSuccess(ITestResult result) {
//	System.out.println("Test Passed: " + result.getName());
//		
//	}
}
