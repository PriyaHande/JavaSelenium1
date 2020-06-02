package HeadlessBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class headlessChromeDemo {
	@Test
	public static void test() {

		System.setProperty("webdriver.chrome.driver","E:\\Priya_Eclipse_projects_from11April2020\\SeleniumJavaFramework\\Browserdrivers\\chromeDriver\\chromedriver.exe");
		String projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");

		//headless code (https://sites.google.com/a/chromium.org/chromedriver/capabilities)
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // or options.addArguments("headless");
		options.addArguments("window-size=1280,800");

		WebDriver driver = new  ChromeDriver(options);

		driver.get("https://duckduckgo.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("ABCD");
		driver.findElement(By.id("search_button_homepage")).sendKeys(Keys.RETURN);

		driver.close();
		System.out.println("Test completed");
	}

}
