package Package_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryFailedTestCasesManually
{
	@Test
	public void test1()
	{
		//System.out.println("Inside test 1");
	}

	@Test
	public void test2() 
	{
		//System.out.println("Inside test 2");
		//fail test 2 deliberately
		//int i=1/0;
	}

	@Test(retryAnalyzer = RetryFailedTestCasesAutomation.class)
	public void test3() 
	{
		//System.out.println("Inside test 3");
		//fail test 3 deliberately
		Assert.assertTrue(false);
	}

}
