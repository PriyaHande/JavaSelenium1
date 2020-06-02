package Utils;

public class ExcelUtilsDemo {
	
	public static void main(String[] args) {
		
		String projectpath= System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectpath+"/Excel/data.xlsx", "Sheet1");

		ExcelUtils.getRowCount();
		ExcelUtils.getCellDataString(0, 0);
		ExcelUtils.getCellDataNumber(1, 1);
		ExcelUtils.getColumnCount();
	}

}
