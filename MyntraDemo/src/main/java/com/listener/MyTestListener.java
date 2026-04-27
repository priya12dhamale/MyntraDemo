package com.listener;

import org.testng.ITestListener;

import org.testng.ITestResult;

import com.myntra.base.KeyWord;
import com.myntra.utils.Screenshot;


public  class MyTestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		Screenshot.captureScreenshot(KeyWord.driver, testName); 
	}

}
