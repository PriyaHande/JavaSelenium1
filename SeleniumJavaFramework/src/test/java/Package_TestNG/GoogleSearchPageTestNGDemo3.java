package Package_TestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObjectModelTest.GoogleSearchPageObjectLocators;

public class GoogleSearchPageTestNGDemo3 
{
	static WebDriver driver = null;
	
	@BeforeSuite
	public void setUpTest()
	{
		//RELATIVE LOCATION
		String projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");

		//If we set chromDriver path as system environmental variable
		driver = new ChromeDriver();
	}
	@Test
	//method
	public static void googleSearchTest1()
	{
		//create object/instance of class to pass arguments
		GoogleSearchPageObjectLocators searchPageObject = new GoogleSearchPageObjectLocators(driver);

		/*write testCases below */
		//go to google.com / duckduckgo.com
		driver.get("https://duckduckgo.com/");

		//getting size of window
		System.out.println(driver.manage().window().getSize());

		//maximize browser, setSize of window
		driver.manage().window().maximize();

		Dimension d = new Dimension(420, 600);
		//Resize the current window to the given dimension
		driver.manage().window().setSize(d);

		//to call any function defined in class
		searchPageObject.SetTextInSearchBox("Automation step by step");

		//give implicit wait
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		//give default explicit wait
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchPageObject.ClickSearchButton();
	}

	@AfterSuite
	public void tearDownTest()
	{
		//close browser
		driver.close();
		System.out.println("Test Completed Successfully");

	}
}
