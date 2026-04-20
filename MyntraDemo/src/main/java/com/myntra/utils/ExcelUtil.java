package com.myntra.utils;

import java.util.List;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Object[][] getTestData(String sheetName) {

		try {

			String filePath = "src/test/resources/testdata/testdata.xlsx";

			FileInputStream file = new FileInputStream(filePath);

			Workbook workbook = WorkbookFactory.create(file);

			Sheet sheet = workbook.getSheet(sheetName);

			int rowCount = sheet.getPhysicalNumberOfRows();

			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			Object[][] data = new Object[rowCount - 1][colCount];

			for (int i = 1; i < rowCount; i++) {

				for (int j = 0; j < colCount; j++) {

					data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
				}
			}

			workbook.close();

			return data;

		} catch (Exception e) {

			e.printStackTrace();

			return null;
		}
	}
}
