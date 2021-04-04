package excel_operations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelDemo1 
{

	public static void main(String[] args) throws IOException 
	{
		//create a workbook
		XSSFWorkbook wb = new XSSFWorkbook();
		
		//create a sheet and name it
		XSSFSheet sheet = wb.createSheet("Emp Info");
		
		//we need data in some data structure
		//here we will use 2D object array
		Object empData[][] = {	{"EmpID","Name", "Job"},
								{101,"David","Engineer"},
								{102,"Smith","Manager"},
								{103,"Scott","Manager"},
								{104,"Jim","Accountant"},
								{105,"Pam","Admin"}
							};	
		
		//USING FOR LOOP
//		int rows = empData.length;
//		int cols = empData[0].length;
//		
//		for(int r=0; r<rows; r++)
//		{
//			XSSFRow row = sheet.createRow(r);
//			for(int c=0; c<cols; c++)
//			{
//				XSSFCell cell = row.createCell(c);
//				Object value = empData[r][c];
//				
//				if(value instanceof String)
//				{
//					cell.setCellValue((String)value);
//				}
//				if(value instanceof Integer)
//				{
//					cell.setCellValue((Integer)value);
//				}
//				if(value instanceof Boolean)
//				{
//					cell.setCellValue((Boolean)value);
//				}
//			}
//		}
		
		//USING FOR...EACH LOOP
		int rowCount = 0;
		for(Object emp[]:empData)
		{
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount = 0;
			for(Object value:emp)
			{
				XSSFCell cell = row.createCell(columnCount++);
				
				if(value instanceof String)
				{
					cell.setCellValue((String)value);
				}
				if(value instanceof Integer)
				{
					cell.setCellValue((Integer)value);
				}
				if(value instanceof Boolean)
				{
					cell.setCellValue((Boolean)value);
				}
			}
		}
		
		String path = ".\\dataFiles\\employee.xlsx";
		FileOutputStream outputStream = new FileOutputStream(path);
		wb.write(outputStream);
		outputStream.close();
		
		System.out.println("\nWritten to excel file successfully.");
	}

}
