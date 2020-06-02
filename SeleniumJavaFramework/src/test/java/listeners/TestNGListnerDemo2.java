package listeners;

import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListnerDemo2 {

	@Test
	public void test4() {
		System.out.println("I'm inside test 4");
	}

	@Test
	public void test5() {
		System.out.println("I'm inside test 5");
		//Assert.assertTrue(false);
	}

	@Test
	public void test6() {
		System.out.println("I'm inside test 6");
		throw new SkipException("This test is skipped");
	}




}
