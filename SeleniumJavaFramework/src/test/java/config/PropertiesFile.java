package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile{
	static Properties prop = new Properties();
	static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) throws IOException {
		getProperties(); 
		setProperties();
		getProperties();
		setProperties();
	}

	public static void getProperties() {
		try {

			InputStream input = new FileInputStream(projectpath+"/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println("browser name: "+browser);//print 1
			testng_config_properties.browserName = browser;
		}
		catch(Exception exp) {
			System.out.println("I'm inside catch block");
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	public static void setProperties() throws IOException 
	{
		OutputStream output = new FileOutputStream(projectpath+"/src/test/java/config/config.properties");
		prop.setProperty("result", "Pass");
		//prop.store(output, null);
		prop.setProperty("browser", "Chrome");

	}

}


