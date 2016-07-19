package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File ("./ApplicationTestData/AppData.xlsx");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
		System.out.println("exception is " +e.getMessage());
		}
	}
	
	public String getData(int index, int row, int col)
	{
		String data = wb.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	public String getData(String  name, int row, int col)
	{
		String data = wb.getSheet(name).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
}
