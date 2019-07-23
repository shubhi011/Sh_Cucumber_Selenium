package com.webdriver.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
	
	public static void main(String[]args) throws IOException
	{
		File file=new File("C:\\Users\\312234\\Documents\\seleniumReadExcel.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		            
		
		for(int r=sheet.getFirstRowNum();r<=sheet.getLastRowNum();r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int col=row.getFirstCellNum();col<=row.getLastCellNum();col++)
			{
				  XSSFCell cell=row.getCell(col);
				 switch (cell.getCellType()) {
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
					
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					
				case BLANK:
					System.out.println("blank cell");
	
				default:
					break;
				}
			}
		}
		
		wb.close();
	}
}

//For poi-4.1.0 I had to add these to the classpath: dom4j-1.6.jar xmlbeans-3.1.0.jar commons-collections4-4.3.jar commons-compress-1.18.jar Only then did this work for Excel.xlsx File:
//
//ExcelWBook = new XSSFWorkbook(ExcelFile);
