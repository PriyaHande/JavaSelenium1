package WaitsInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumWaitDemo {
	WebDriver driver= null;

	@Test
	public void SeleniumWait() {

		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://duckduckgo.com/");

		//sending text in search field
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Automation step by step");

		//Thread.sleep(3000);
		//clicking Google search button
		//driver.findElement(By.id("search_button_homepage")).click();

		//same as pressing enter button
		driver.findElement(By.id("search_button_homepage")).sendKeys(Keys.RETURN);
		//	Thread.sleep(3000);

		//implicit wait
		/*
		 * default frequency of polling -- 250 milliseconds
		by default it is set to 0
		is applicable for entire session of browser
		 */
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//---------------------------------------------------------------------------------------------

		//explicit Wait
		/*can be set for a specific condition (Eg: wait until element is clickable) */

		//	WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("abcd")));
		//----------------------------------------------------------------------------------

		
		
		driver.findElement(By.id("abcd")).click();

		//close the browser 
		driver.close();



		System.out.println("SeleniumWaitDemo test completed");



	}

}
