package excel_operations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelDemo2 
{

	public static void main(String[] args) throws IOException 
	{
		//create a workbook
				XSSFWorkbook wb = new XSSFWorkbook();
				
				//create a sheet and name it
				XSSFSheet sheet = wb.createSheet("Emp Info");
				
				//we need data in some data structure
				//here we will use 2D object array
				ArrayList<Object[]> empData = new ArrayList<Object[]>();
				empData.add(new Object[]{"EmpID","Name", "Job"});
				empData.add(new Object[]{101,"David","Engineer"});
				empData.add(new Object[]{102,"Smith","Manager"});
				empData.add(new Object[]{103,"Scott","Manager"});
				empData.add(new Object[]{104,"Jim","Accountant"});
				empData.add(new Object[]{105,"Pam","Admin"});
				
				//USING FOR...EACH LOOP
				int rowCount = 0;
				for(Object[] emp:empData)
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
