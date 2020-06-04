package SauceLabs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;


public class SauceLabsDemo {

	public static final String USERNAME = "PriyaJumle";
	public static final String ACCESS_KEY = "83fd5566-1d69-4a7a-bfec-18e7567d5d23";
	public static final String URL = "http://" + "PriyaJumle" + ":" + "83fd5566-1d69-4a7a-bfec-18e7567d5d23" + "@ondemand.saucelabs.com:80/wd/hub";

	static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		ChromeOptions options = new ChromeOptions();
		options.setCapability("platform", "Windows 10");
		options.setCapability("version", "latest");
		options.setCapability("name", "GoogleTest");
		options.setCapability("extendedDebugging", true);
		options.setCapability("capturePerformance", true);
		options.setCapability("build", "build 1");
		driver = new RemoteWebDriver(new URL(URL), options);

		/*
   		projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath); 
		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");
		 */		 

		driver.get("http://www.google.com");
		System.out.println("title of page is: "+driver.getTitle());
		//driver = new ChromeDriver(options);
		//driver=new ChromeDriver();

		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		Thread.sleep(2000);

		//clicking Google search button
		driver.findElement(By.name("btnK")).click();
		driver.quit();
		
		System.out.println("SauceLabsDemo test completed");
	}
}
