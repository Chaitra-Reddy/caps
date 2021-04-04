package excel_operations;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDatabase 
{

	public static void main(String[] args) throws SQLException, IOException 
	{
		//Database connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/forcaps","root","Toradora@1211");
		Statement stmt=con.createStatement();
		
		//create a new table in the database 'places'
		String sql = "CREATE TABLE AGENTS1(AGENT_CODE VARCHAR(6), AGENT_NAME VARCHAR(40), WORKING_AREA VARCHAR(35),COMMISSION float(2),PHONE_NO VARCHAR(15),COUNTRY VARCHAR(25))";
		stmt.execute(sql);
		
		//Excel
		FileInputStream fis = new FileInputStream(".\\dataFiles\\agents.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Agents Data");
		
		int rows = sheet.getLastRowNum();
		
		for(int r=1; r<=rows; r++)
		{
			XSSFRow row = sheet.getRow(r);
			String agentCode = row.getCell(0).getStringCellValue();
			String agentName = row.getCell(1).getStringCellValue();
			String workingArea = row.getCell(2).getStringCellValue();
			double comission = row.getCell(3).getNumericCellValue();
			String phoneNo = row.getCell(4).getStringCellValue();
			String country = row.getCell(5).getStringCellValue();
			
			sql = "INSERT INTO agents1 VALUES('"+agentCode+"','"+agentName+"','"+workingArea+"','"+comission+"','"+phoneNo+"','"+country+"')";
			stmt.execute(sql);
			stmt.execute("commit");
		}
		
		workbook.close();
		fis.close();
		con.close();
		
		System.out.println("Done !!");
	}

}
