package Package_TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterisedTests {
	
	@Parameters({"MyName"})
	@Test
	public void test(@Optional("HarshPriya") String name) {
		System.out.println("testng6.xml");
		
		System.out.println("Name is: "+name);
	}

}
