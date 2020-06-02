package WaitsInSelenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;
public class FluentWaitDemo {

	WebDriver driver;

	//Fluent wait
	/*a class in Selenium api
	 * apply wait to specific element
	 * set max wait time period
	 * set polling frequency
	 * set to ignore specific exceptions*/
	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Priya_Eclipse_projects_from11April2020\\SeleniumJavaFramework\\Browserdrivers\\chromeDriver\\chromedriver.exe");
		String projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://duckduckgo.com/");

		//sending text in search field
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Automation step by step");

		//same as pressing enter button
		driver.findElement(By.id("search_button_homepage")).sendKeys(Keys.RETURN);

		//fluent wait
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		//https://stackoverflow.com/questions/58327038/the-method-withtimeoutduration-in-the-type-fluentwaitwebdriver-is-not-applic
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkedText= driver.findElement(By.partialLinkText(" - Raghav Pal - YouTube"));
				
				if(linkedText.isEnabled())
				{
					System.out.println("Element found");
				}
				return linkedText;
			}
		});
		
		element.click();
		driver.close();
	}

}


