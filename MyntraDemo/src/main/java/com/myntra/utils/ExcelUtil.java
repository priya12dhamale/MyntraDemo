package com.myntra.utils;

import java.util.List;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
//	public static Object[][] readExcel(int sheetIndex) throws IOException {
//
//		FileInputStream file = new FileInputStream("src/test/resources/testdata1.xlsx");
//		XSSFWorkbook book = new XSSFWorkbook(file);
//
//		XSSFSheet sheet = book.getSheetAt(sheetIndex);
//
//		int rows = sheet.getPhysicalNumberOfRows();
//
//		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
//		Object[][] data = new Object[rows - 1][cols];
//
//		for (int i = 1; i < rows; i++) {
//
//			XSSFRow row = sheet.getRow(i);
//
//			for (int j = 0; j < cols; j++) {
//				XSSFCell cell = row.getCell(j);
//
//				switch (cell.getCellType()) {
//				case STRING:
//					String value = cell.getStringCellValue();
//					data[i - 1][j] = value;
//					System.out.println(value);
//					break;
//
//				case NUMERIC:
//					int value1 = (int) cell.getNumericCellValue();
//					data[i - 1][j] = value1;
//					System.out.println(value1);
//
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
//				}
//
//			}
//
//		}
//		return data;
//	}
}
