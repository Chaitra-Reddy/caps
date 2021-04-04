package excel_operations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel 
{

	public static void main(String[] args) throws IOException 
	{
		//create a workbook
		XSSFWorkbook wb = new XSSFWorkbook();
		
		//create a sheet and name it
		XSSFSheet sheet = wb.createSheet("Student data");
		
		Map<String,String> data = new HashMap<String,String>();
		data.put("101", "Scott");
		data.put("102", "Dwight");
		data.put("103", "Jim");
		data.put("104", "Pam");
		data.put("105", "Angela");
		
		int rowCount = 0;
		for(Map.Entry<String, String> entry:data.entrySet())
		{
			XSSFRow row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue((String)entry.getKey());
			row.createCell(1).setCellValue((String)entry.getValue());
		}
		
		FileOutputStream outputStream = new FileOutputStream(".\\dataFiles\\student.xlsx");
		wb.write(outputStream);
		outputStream.close();
		System.out.println("Written hash map to excel successfully.");
	}

}
