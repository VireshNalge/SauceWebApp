package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class ShoppingRemoveProduct {
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver= new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.saucedemo.com/");
			
			// Login
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
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

	        // Remove product
	        driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.id("continue-shopping")).click();
	        
	        Thread.sleep(2000);
	        driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
			driver.quit();
	                
	                
}
	

}
