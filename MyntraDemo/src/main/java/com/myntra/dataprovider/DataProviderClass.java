package com.myntra.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import com.myntra.utils.ExcelUtil;

public class DataProviderClass {
   


	@DataProvider(name = "categoryData")
	public static Object[][] getCategoryData() {

		Object[][] fullData = ExcelUtil.getTestData("FilterData");

		Object[][] categoryOnly = new Object[fullData.length][1];

		for (int i = 0; i < fullData.length; i++) {

			categoryOnly[i][0] = fullData[i][0];
		}

		return categoryOnly;
	}
	

//    @DataProvider(name = "categoryData
//
//    public static Object[][] getFilterData() {
//
//        return ExcelUtil.getTestData("FilterData");
//
//    }
// 
}
