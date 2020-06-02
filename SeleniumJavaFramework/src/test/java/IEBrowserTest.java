import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowserTest {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.ie.driver","D:\\PriyaFolderForWorkspaces\\Priya_Eclipse_projects_from11April2020\\SeleniumJavaFramework\\Browserdrivers\\IEDriver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/");

		Thread.sleep(2000);

		
		System.out.println(driver.getTitle());
		//driver.quit();
		driver.close();
        driver.quit();
        //not closing the browser after completing the test

	}

}
