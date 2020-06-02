package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName)  {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}

	public static int getRowCount()
	{
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows: "+ rowCount);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}

	//For UserName
	public static String getCellDataString(int rowNum, int colNum)
	{
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("CellData is: "+cellData);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}

	//For Password
	public static void getCellDataNumber(int rowNum,int colNum)
	{
		try {	
			//for only numeric value
			//double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//for alphanumeric values
			String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println("CellData is: "+cellData);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	public static int getColumnCount()
	{
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of columns: "+ colCount);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}



}
