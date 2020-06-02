package WebElementsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleWebsiteTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","E:\\Priya_Eclipse_projects_from11April2020\\SeleniumJavaFramework\\Browserdrivers\\chromeDriver\\chromedriver.exe");


		//RELATIVE LOCATION
		String projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");

		//If we set chromDriver path as system environmental variable

		WebDriver driver = new ChromeDriver();
		
		//go to google.com
		driver.get("https://www.google.com/");

		//sending text in search field
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		
		Thread.sleep(3000);
		
		//clicking Google search button
		driver.findElement(By.name("btnK")).click();
		
		//same as pressing enter button
		//driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);
		
		Thread.sleep(3000);

		driver.close();
		System.out.println("test completed");

	}

}
