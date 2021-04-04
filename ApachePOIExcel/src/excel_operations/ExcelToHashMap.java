package excel_operations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap 
{

	public static void main(String[] args) throws IOException 
	{
		String path = ".\\dataFiles\\student.xlsx";
		
		FileInputStream inputStream = new FileInputStream(path);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = wb.getSheet("Student data");
		
		int rows = sheet.getLastRowNum();
		
		Map<String,String> data = new HashMap<String,String>();
		
		for(int r=0; r<=rows; r++)
		{
			String key = sheet.getRow(r).getCell(0).getStringCellValue();
			String value = sheet.getRow(r).getCell(1).getStringCellValue();
			data.put(key, value);
		}
		
		for(Map.Entry<String, String> entry:data.entrySet())
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
