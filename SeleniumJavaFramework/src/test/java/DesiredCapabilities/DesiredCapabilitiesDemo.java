package DesiredCapabilities;
///NOT WORKING on ie
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo
{
	static WebDriver driver = null;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception
	{
		//Protected Mode settings are not the same for all zones.
		//Enable Protected Mode must be set to the same value (enabled or disabled) for all zones.
	DesiredCapabilities caps = new DesiredCapabilities();caps.setCapability("ignoreProtectedModeSettings",true);
				
		//RELATIVE LOCATION
		String projectPath= System.getProperty("user.dir");
		System.out.println("projectPath: "+projectPath);
		System.setProperty("webdriver.ie.driver",projectPath+"/Browserdrivers/IEDriver/IEDriverServer.exe");
		
		driver = new InternetExplorerDriver(caps);
		/*
		InternetExplorerOptions options = new InternetExplorerOptions().requireWindowFocus();
		//options = setCapability("ignoreProtectedModeSettings", true);
	driver = new InternetExplorerDriver(options);
*/
		driver.get("https://duckduckgo.com/");
		//Thread.sleep(2000);
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Automation step by step");
		Thread.sleep(70000);
		driver.findElement(By.className("search__button js-search-button")).click();
		
	//driver.get("https://www.google.com/");
	//driver.findElement(By.className("gLFyf")).sendKeys("A B C D");
		driver.close();
		//driver.quit();
		
		
	}
	

}
