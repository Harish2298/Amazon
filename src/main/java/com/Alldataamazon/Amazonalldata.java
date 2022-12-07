package com.Alldataamazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Amazonalldata {//dataDriven=It is a Framework, Where we Read and Write the Data or input
	static String Value;   // which is stored in Excel Format

	public static String allData(String sheet,int rowNo, int cellNo) throws IOException {
		File t = new File("/Users/r.harish/Desktop/Java/SubjectMark.xlsx");
		FileInputStream F = new FileInputStream(t);
		Workbook w = new XSSFWorkbook(F); // UpCasting
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		CellType cell = c.getCellType();

		if (cell.equals(CellType.STRING)) {
			Value = c.getStringCellValue();
			

		} else if (cell.equals(CellType.NUMERIC)) {
			double numeric = c.getNumericCellValue();
		    int p = (int) numeric; // narrowing casting
          Value=String.valueOf(p);
        
		}
		return Value;
	}
	public static void main(String[] args) throws IOException {
		allData(Value, 0, 0);
	}
}
