package com.crm.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author mabasha
 *
 */
public class ExcelUtility 
{
	/**
	 * this is a generic method to read data from excel sheet
	 * 
	 * @param
	 * @param
	 * @param
	 * @return this will return value of cell in string type.
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static String getTestData(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	/**
	 * This is a generic method to write data in excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @param status
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void putTestData(String sheetname, int row, int cell, String status) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(status);
		FileOutputStream fos = new FileOutputStream("./data/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
	

}
