package ExtentReportDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBasicDemo
{
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception 
	{		
		// start reporters

		// --is Deprecated -- ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		ExtentSparkReporter  htmlReporter = new ExtentSparkReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test1 = extent.createTest("GoogleSearchTest", "This is test to validate google search functionality");

		//RELATIVE LOCATION
		String projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");

		//If we set chromDriver path as system environmental variable

		driver = new ChromeDriver();

		// log(Status, details)
		test1.log(Status.INFO, "Staring testcase");
		//go to google.com
		driver.get("https://duckduckgo.com/");
		test1.pass("Navigate to duckduckgo.com");

		//sending text in search field
		driver.findElement(By.name("q")).sendKeys("Automation step by step");

		test1.pass("Entered text in search box");
		Thread.sleep(3000);

		//clicking Google search button
		driver.findElement(By.id("search_button_homepage")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard Enter key");

		//same as pressing enter button
		//driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);

		Thread.sleep(3000);

		driver.close();
		test1.pass("closed the browser");


		//2nd test demo
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test2 = extent.createTest("GoogleSearchTest", "This is test to validate google search functionality");

		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");

		//If we set chromDriver path as system environmental variable

		driver = new ChromeDriver();

		// log(Status, details)
		test2.log(Status.INFO, "Staring testcase");
		//go to google.com
		driver.get("https://duckduckgo.com/");
		test2.pass("Navigate to duckduckgo.com");

		//sending text in search field
		driver.findElement(By.name("q")).sendKeys("Automation step by step");

		test2.pass("Entered text in search box");
		Thread.sleep(3000);

		//clicking Google search button
		driver.findElement(By.id("search_button_homepage")).sendKeys(Keys.RETURN);
		test2.pass("Pressed keyboard Enter key");

		//same as pressing enter button
		//driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);

		Thread.sleep(3000);

		driver.close();
		test2.fail("closed the browser");

		test2.pass("Test completed");

		// calling flush writes everything to the log file
		extent.flush();

	}

}
