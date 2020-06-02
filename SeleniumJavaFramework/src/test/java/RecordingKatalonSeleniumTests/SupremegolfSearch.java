package RecordingKatalonSeleniumTests;

//supremegolf automation with Katalon recording tool some webelements not get clicked

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SupremegolfSearch {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		String projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSupremegolfSearch() throws Exception {
		driver.get("https://supremegolf.com/");
		driver.findElement(By.id("q_home")).click();
		driver.findElement(By.id("q_home")).clear();
		driver.findElement(By.id("q_home")).sendKeys("Dallas");
		driver.findElement(By.xpath("//div[8]/p[2]")).click();
		driver.findElement(By.xpath("//div[10]/div/div/p")).click();
		driver.findElement(By.xpath("//img[@alt='X']")).click();
		driver.findElement(By.xpath("//tr[@id='tee_time_312413697']/td[8]")).click();
		driver.findElement(By.id("m-search__filter")).click();
		driver.findElement(By.xpath("//div[@id='js-tee-times-filter']/form/div/div[3]/div[2]/label/p")).click();
		driver.findElement(By.id("js-filters-close-btn")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
