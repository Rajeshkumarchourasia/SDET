package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *   It is created using Apache POI which is used to do Read/Write from Excel
 * @author user
 *
 */

public class ExcelUtility {

/**
 * Used to access Data from The Specific Cell of Excel Sheet
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @return String Data
 * @throws Throwable
 */
	public String getDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./Data/TestDetails.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(rowNo);
		String cellVaule=row.getCell(cellNo).getStringCellValue();
		wb.close();
		return cellVaule;
		
	}
	
	
	
}
