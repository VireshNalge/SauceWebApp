package Validation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CheckTitle {
    
	public static void main(String[] args) {
		String expectedTitle = "Facebook";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		String actualTitle = driver.getTitle();
	/*	 // Hard Assert
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("step1");
		System.out.println("step2");
		driver.quit();*/
		
		// Soft Assert
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualTitle, expectedTitle);
		System.out.println("step1");
		System.out.println("step2");
		soft.assertAll();
		driver.quit();

	}
	
	

}
