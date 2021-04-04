package excel_operations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatabaseToExcel 
{

	public static void main(String[] args) throws SQLException, IOException 
	{
		//connect to the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/forcaps","root","Toradora@1211");

		//statement/query
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from agents");
		
		//Excel
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Agents Data");
		
		XSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("AGENT_CODE");
		row.createCell(1).setCellValue("AGENT_NAME");
		row.createCell(2).setCellValue("WORKING_AREA");
		row.createCell(3).setCellValue("COMMISSION");
		row.createCell(4).setCellValue("PHONE_NO");
		row.createCell(5).setCellValue("COUNTRY");
		
		int r = 1;
		while(rs.next())
		{
			String agentCode = rs.getString("AGENT_CODE");
			String agentName = rs.getString("AGENT_NAME");
			String workingArea = rs.getString("WORKING_AREA");
			double comission = rs.getDouble("COMMISSION");
			String phoneNo = rs.getString("PHONE_NO");
			String country = rs.getString("COUNTRY");
			
			row = sheet.createRow(r++);
			row.createCell(0).setCellValue(agentCode);
			row.createCell(1).setCellValue(agentName);
			row.createCell(2).setCellValue(workingArea);
			row.createCell(3).setCellValue(comission);
			row.createCell(4).setCellValue(phoneNo);
			row.createCell(5).setCellValue(country);
		}
		
		FileOutputStream fos = new FileOutputStream(".\\datafiles\\agents.xlsx");
		workbook.write(fos);
		
		workbook.close();
		fos.close();
		con.close();
		
		System.out.println("Done!!!");
	}

}
