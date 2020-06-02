package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListnerDemo {

	@Test
	public void test1() {
		System.out.println("I'm inside test 1");
	}

	@Test
	public void test2() throws InterruptedException {
		System.out.println("I'm inside test 2");
		//Assert.assertTrue(false);

		String projectPath= System.getProperty("user.dir");
		//System.out.println("projectPath: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");
		//If we set chromDriver path as system environmental variable
		WebDriver driver = new ChromeDriver();
		//go to google.com / duckduckgo.com
		driver.get("https://duckduckgo.com/");
		Thread.sleep(3000);
		//to call any function defined in class
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void test3() {
		System.out.println("I'm inside test 3");
	}




}
