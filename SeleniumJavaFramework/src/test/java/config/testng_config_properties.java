package config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Log4j.Log4jDemo;

public class testng_config_properties {
	static WebDriver driver = null;
	public static String browserName = null;
	private static Logger logger = (Logger) LogManager.getLogger(Log4jDemo.class);

	@BeforeTest
	public void setUpTest() {
		PropertiesFile.getProperties();
		String projectPath= System.getProperty("user.dir");

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://duckduckgo.com/");
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",projectPath+"\\Browserdrivers\\geckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.google.com/");
		}

		logger.info("Browser Started");
	}

	@Test
	public static void googleSearchTest()
	{
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
	}

	@AfterTest
	public void tearDownTest() throws IOException
	{
		//close browser
		driver.close();
		System.out.println("Test Completed Successfully");
		PropertiesFile.setProperties();

	}
}
