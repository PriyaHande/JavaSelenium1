package Package_TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore  //ignore tests at class level
public class IgnoreTests {
	
	//@Ignore
	@Test
	@Ignore //particular test gets ignored
	public void test1() {
		System.out.println("Inside test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside test 2");
	}

}
