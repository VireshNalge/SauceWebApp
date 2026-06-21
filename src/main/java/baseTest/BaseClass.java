package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CartPage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver = null;
	public static WebDriver sdriver = null;// listener
	public PropertiesFileUtility putil= new PropertiesFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	
	@BeforeSuite(groups= {"smoke","regression"})
	  public void beforeSuite() {
		  Reporter.log("DB open",true);
	  }
	
	//@Parameters("BROWSER")
	 @BeforeClass (groups= {"smoke","regression"})
	  public void beforeClass() throws Throwable {
		 
		  String BROWSER = putil.toReadDataFromPropertiesFiles("Browser");
		// String BROWSER = System.getProperty("Browser");

	        // Browser launch
	        if(BROWSER.equals("Edge"))
	        {
	            driver = new EdgeDriver();
	        }
	        else if(BROWSER.equals("Chrome"))
	        {
	            driver = new ChromeDriver();
	        }
	        else if(BROWSER.equals("Firefox"))
	        {
	            driver = new FirefoxDriver();
	        }
	        sdriver=driver;
		  Reporter.log("launch browser",true);
	  }
	
	  @BeforeMethod (groups= {"smoke","regression"})
	  public void beforeMethod() throws Throwable {
		  
		    String URL = putil.toReadDataFromPropertiesFiles("Url");
	        String USERNAME = putil.toReadDataFromPropertiesFiles("Username");
	        String PASSWORD = putil.toReadDataFromPropertiesFiles("Password");

		  driver.manage().window().maximize();
	        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        wutil.waitForPageToLoad(driver);

	        driver.get(URL);

	        // Login
	        // implementation of  POM
	         LoginPage lp = new LoginPage(driver);
	         lp.getUser().sendKeys(USERNAME);
	         lp.getPwd().sendKeys(PASSWORD);
	         lp.getLoginBtn().click();
		  Reporter.log("login",true);
	  }

	  @AfterMethod (groups= {"smoke","regression"})
	  public void afterMethod() {
		  CartPage cp = new CartPage(driver);
		  cp.getBurgerIcon().click();
		  cp.getLogout().click();
		  Reporter.log("logout",true);
	  }

	  @AfterClass (groups= {"smoke","regression"})
	  public void afterClass() {
		  driver.quit();
		  Reporter.log("close browser",true);
	  }

	  @AfterSuite (groups= {"smoke","regression"})
	  public void afterSuite() {
		  Reporter.log("DB close",true);
	  }


}
