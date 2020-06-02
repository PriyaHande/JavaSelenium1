package GroupinginTestNG;

import org.testng.annotations.Test;

public class GroupsDemo {
	
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("testng4.xml");
		System.out.println("This is test 1");
	}
	
	@Test(groups = {"sanity", "smoke"})
	public void test2() {
		System.out.println("This is test 2");
	}
	
	@Test(groups = {"regression", "sanity"})
	public void test3() {
		System.out.println("This is test 3");
	}
	
	@Test
	public void test4() {
		System.out.println("This is test 4");
	}

}
