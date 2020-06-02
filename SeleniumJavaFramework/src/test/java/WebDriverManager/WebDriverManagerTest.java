package WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

	public static void main(String[] args) {
		WebDriver driver;
		
		//for running in particular chrome version
	//	WebDriverManager.chromedriver().version("2.36").setup();
		
		// for running on latest chrome version
		//WebDriverManager.chromedriver().setup();
		
		//driver = new ChromeDriver();
		
		// to run on latest firefox driver		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		
		driver.get("https://www.google.com/");
		
		driver.close();
	}

}
