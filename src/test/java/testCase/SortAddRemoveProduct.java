package testCase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SortAddRemoveProduct {

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
				// Dropdwon
				WebElement dropdown = driver.findElement(By.className("product_sort_container"));

		        Select select = new Select(dropdown);

		        select.selectByVisibleText("Price (high to low)");
		        
		     // Add highest product
		        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		        
		        // Open cart
		        driver.findElement(By.className("shopping_cart_link")).click();
		        //Thread.sleep(2000);
		        // Validation
		        String productName =driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
		        Thread.sleep(2000);      
		        System.out.println("Added Product: " + productName);
		        //Thread.sleep(2000);

		       
		        
		        Thread.sleep(2000);
		        driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.linkText("Logout")).click();
				Thread.sleep(2000);
				driver.quit();
		                
		                
	}

}
