package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
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
import org.testng.annotations.Test;

import baseTest.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CartPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;

public class TC_01_AddProductToCart extends BaseClass {

	@Test(groups = {"smoke","regression"})
		public void toaddProdToCartTest() throws Throwable {
		
			  ExcelUtility eutil= new ExcelUtility();
			  
		      String prodname = eutil.toReadDataFromExcel("Products", 1, 2);
//				
				// Add Product to cart
		        ProductPage pp = new ProductPage(driver);
		        CartPage cp = new CartPage(driver); 
		        pp.getProdName().click();
		        pp.getAddToCartBtn().click();
		        
		        // nav to cart
				pp.getCartIcon().click();
		        
				// Validation
				//String prodInCart = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
				String prodInCart = cp.getInventItem().getText();
				Assert.assertEquals(prodInCart, prodname);
				}
}
				


