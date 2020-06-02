package Package_TestNG;

import org.testng.annotations.Test;

public class TestNGDependencies {
	
	//@Test(dependsOnMethods  = {"test2", "test3"})
	@Test(dependsOnGroups = {"sanity 1", "sanity.*"})
	public void test1() {
		System.out.println("testng7.xml");
		System.out.println("I'm inside test 1");
	}
	
	//@Test
	@Test(groups = {"sanity 1"})
	public void test2() {
		System.out.println("I'm inside test 2");
	}
	
	@Test(groups = {"sanity 2"})
	public void test3() {
		System.out.println("I'm inside test 3");
	}

}
