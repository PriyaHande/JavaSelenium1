package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {

	WebDriver driver = null;
	@BeforeTest
	public void setUpTest() {

		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(dataProvider = "test1Data")
	public void test1(String Username , String Password) {
		System.out.println(Username+" | "+ Password);
		driver.get("https://duckduckgo.com/");
		//getting size of window
		System.out.println(driver.manage().window().getSize());
		//maximize browser, setSize of window
		driver.manage().window().maximize();
		Dimension d = new Dimension(420, 600);
		//Resize the current window to the given dimension
		driver.manage().window().setSize(d);
		//to call any function defined in class
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Automation step by step");
		//use excel sheet data in website 
	}

	@DataProvider(name = "test1Data")
	public static Object[][] getData() {
		String excelPath = "E:\\PriyaFolderForWorkspaces\\Priya_Eclipse_projects_from11April2020\\SeleniumJavaFramework\\Excel\\data.xlsx";

		Object data[][] = testData(excelPath, "Sheet1");	
		return data;

	}



	public static Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = ExcelUtils.getRowCount();
		int colCount = ExcelUtils.getColumnCount();

		//object array
		Object data[][] = new Object[rowCount - 1][colCount];


		for(int i=1 ; i<rowCount ; i++)
		{
			for(int j=0 ; j<colCount ; j++)
			{
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			System.out.println();
		}
		return data;
	}

}
