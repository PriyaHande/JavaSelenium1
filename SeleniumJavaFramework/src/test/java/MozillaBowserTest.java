import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaBowserTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver","D:\\PriyaFolderForWorkspaces\\Priya_Eclipse_projects_from11April2020\\SeleniumJavaFramework\\Browserdrivers\\geckoDriver\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver(); 
		driver.get("https://www.selenium.dev/");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}
