package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Depends {
	@Test
	public void createacc()
	{
		Reporter.log("created",true);
	}
	@Test(dependsOnMethods = "createacc")
	public void editacc()
	{
		Reporter.log("edited",true);
	}
	@Test(dependsOnMethods = {"createacc","editacc"})
	public void deleteacc()
	{
		Reporter.log("deleted",true);
	}

}
