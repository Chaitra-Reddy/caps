package excel_operations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel 
{

	public static void main(String[] args) throws IOException 
	{
		String path = ".\\dataFiles\\countries.xlsx";
		
		FileInputStream inputStream = new FileInputStream(path);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
//		XSSFSheet sheet = wb.getSheetAt(0);  //--another method
		
		//USING FOR LOOP TO READ DATA
//		int rows = sheet.getLastRowNum();
//		int cols = sheet.getRow(1).getLastCellNum();
//		
//		for(int r=0; r<rows; r++)
//		{
//			XSSFRow row = sheet.getRow(r);
//			for(int c=0; c<cols; c++)
//			{
//				XSSFCell cell = row.getCell(c);
//				
//				switch(cell.getCellType())
//				{
//				case STRING: System.out.print(cell.getStringCellValue()); break;
//				case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
//				case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
//				default:
//					break;
//				}
//				System.out.println(" | ");
//			}
//			System.out.println();
//		}
//		wb.close();
		
		//USING ITERATOR METHOD
		Iterator itr = sheet.iterator();
		
		while(itr.hasNext())
		{
			XSSFRow row = (XSSFRow) itr.next();
			
			Iterator cellItr = row.cellIterator();
			
			while(cellItr.hasNext())
			{
				XSSFCell cell = (XSSFCell) cellItr.next();
				
				switch(cell.getCellType())
				{
				case STRING: System.out.print(cell.getStringCellValue()); break;
				case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
				default:
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}

}
