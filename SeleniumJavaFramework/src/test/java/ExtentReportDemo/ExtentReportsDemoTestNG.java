package ExtentReportDemo;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoTestNG 
{
	ExtentReports extent;
	WebDriver driver;

	//runs before for every test
	@BeforeSuite
	public void setUp()
	{
		// -- is deprecated -- ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
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
	public void test1() throws IOException 
	{
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		driver.get("https://duckduckgo.com/");
		test.pass("Navigate to duckduckgo.com");
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		// info(details)
		test.info("This step shows usage of info(details)");
		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@Test
	public void test2() throws IOException 
	{
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		// info(details)
		test.info("This step shows usage of info(details)");
		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterTest
	public void tearDownTest()
	{
		//close browser
		driver.close();
		System.out.println("Test Completed Successfully");

	}

	//runs before for every test
	@AfterSuite
	public void tearDown()
	{
		// calling flush writes everything to the log file
		extent.flush();
	}

}

