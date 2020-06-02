import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserTest {

	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver","E:\\Priya_Eclipse_projects_from11April2020\\SeleniumJavaFramework\\Browserdrivers\\chromeDriver\\chromedriver.exe");
		

		//RELATIVE LOCATION
		String projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"\\Browserdrivers\\chromeDriver\\chromedriver.exe");

		
		
		//If we set chromDriver path as system environmental variable
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
