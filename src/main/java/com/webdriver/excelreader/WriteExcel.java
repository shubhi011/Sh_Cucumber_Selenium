package com.webdriver.excelreader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\312234\\Documents\\seleniumWriteExcel.xlsx");
		FileOutputStream fout = new FileOutputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheet1");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell=row.createCell(0, CellType.STRING);
		cell.setCellValue("Test data cell");
        wb.write(fout);
        wb.close();
        fout.close();
	}

}
