package testCase;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

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

@Listeners(listenerUtility.ListenerImplementation.class)
public class TC_02_AddLowestProductToCartTest extends BaseClass {
	
	
	@Test(groups = {"smoke","regression"})
	public void addLowestProductToCartTest() throws Throwable {

		  ExcelUtility eutil= new ExcelUtility();
       
         String prodname1 = eutil.toReadDataFromExcel("Products", 4, 3);
         
      // Add Product to cart
	        ProductPage pp = new ProductPage(driver);
	        CartPage cp = new CartPage(driver); 
	        pp.getProdName1().click();
	        pp.getAddToCartBtn().click();
	        
	        // nav to cart
		//	pp.getCartIcon().click(); // comment this to chek failuer seccrn shot 
		        
		     //String prodInCart = cp.getInventItem().getText();
		     String prodInCart = cp.getInventItem().getText();
		     
		     System.out.println("Excel Product : " + prodname1);
		     System.out.println("Cart Product  : " + prodInCart);
				
			if(prodInCart.equals(prodname1))
				{
					System.out.println("Pass");
				}
			else {
					System.out.println("Fail");
				}         
		                
	}
}
