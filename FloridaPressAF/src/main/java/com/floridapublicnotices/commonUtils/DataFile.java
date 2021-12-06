package com.floridapublicnotices.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class DataFile
{
	@SuppressWarnings("resource")
	
	
	public static String CellData(int RowNum, int ColNum) throws IOException {
		
	File src = new File("src\\test\\resources\\TestData.xlsx");
	FileInputStream fis=new FileInputStream(src);
	
	XSSFWorkbook wb = new XSSFWorkbook(fis);

	XSSFSheet sheet = wb.getSheetAt(0);
	
	DataFormatter formatter = new DataFormatter();
	
	Cell celldata= sheet.getRow(RowNum).getCell(ColNum);
	String data = formatter.formatCellValue(celldata);
	
	return data;
	
	}
}
