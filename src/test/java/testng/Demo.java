package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class Demo {
	@Test(enabled = false)
	public void add()
	{
		Reporter.log("add",true);
		}
	@Test(priority = -2)
	public void sub()
	{
		Reporter.log("sub",true);
		}
	@Test
	// By default it as 0
	public void mul()
	{
		Reporter.log("mul",true);
		}

}
