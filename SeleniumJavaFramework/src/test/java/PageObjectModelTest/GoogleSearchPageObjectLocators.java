package PageObjectModelTest;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//it is a locator file for all webElements

public class GoogleSearchPageObjectLocators
{   
	WebDriver driver = null;
	
	//locators of all webelements
	By textbox_search = By.name("q");
	//By button_search = By.className("gNO89b");
	//By button_search = By.name("btnK");
	By button_search = By.id("search_button_homepage");
		
	//constructor
	public  GoogleSearchPageObjectLocators(WebDriver driver)
	{
		this.driver = driver;		
	}
	/* OR
	public  GoogleSearchPageObjectLocators(WebDriver driver1)
	{
		driver = driver1;		
	}
	*/
	//Actions below
	public void SetTextInSearchBox(String text) 
	{
		driver.findElement(textbox_search).sendKeys(text);
	}

	public void ClickSearchButton() 
	{
		//driver.findElement(button_search).sendKeys(Keys.RETURN);
		driver.findElement(button_search).click();
		
	}

}



