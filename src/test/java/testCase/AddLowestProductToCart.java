package testCase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AddLowestProductToCart {

		public static void main(String[] args) throws Throwable {

	        FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");

	        Properties prop = new Properties();
	        prop.load(fis);

	        String URL = prop.getProperty("Url");
	        String BROWSER = prop.getProperty("Browser");
	        String USERNAME = prop.getProperty("Username");
	        String PASSWORD = prop.getProperty("Password");

	        System.out.println(URL);

	        WebDriver driver = null;

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

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        driver.get(URL);

	        // Login
	        driver.findElement(By.id("user-name")).sendKeys(USERNAME);

	        driver.findElement(By.id("password")).sendKeys(PASSWORD);

	        driver.findElement(By.id("login-button")).click();

	        Thread.sleep(2000);
	        FileInputStream fis1 = new FileInputStream("./src/test/resources/Testdata.xlsx");
	         Workbook wb = WorkbookFactory.create(fis1);
	         Sheet sheet = wb.getSheet("Products");
	         Row row = sheet.getRow(4);
	         String prodname1 = row.getCell(3).getStringCellValue();
	         System.out.println(prodname1);
					
			        
			     // Add Lowest product
			        driver.findElement(By.xpath("//div[text()='"+prodname1+"']")).click();
			        driver.findElement(By.id("add-to-cart")).click();
			        
			        // Open cart
			        driver.findElement(By.className("shopping_cart_link")).click();
			        //Thread.sleep(2000);
			        // Validation
			        String prodInCart = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
					
					if(prodInCart.equals(prodname1))
					{
						System.out.println("Pass");
					}
					else {
						System.out.println("Fail");
					}

			       
			        
			        Thread.sleep(2000);
			        driver.findElement(By.id("react-burger-menu-btn")).click();
					driver.findElement(By.linkText("Logout")).click();
					Thread.sleep(2000);
					driver.quit();
			                
			                
		}

}


