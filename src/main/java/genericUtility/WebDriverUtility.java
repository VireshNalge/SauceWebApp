package genericUtility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Explicit Wait
	public void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Switch to Frame using Index
    public void switchToFrame(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    // Switch to Frame using ID or Name
    public void switchToFrame(WebDriver driver, String idorname) {
        driver.switchTo().frame(idorname);
    }
    
 // Switch to Frame using WebElement
    public void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    // Accept Alert
    public void switchToAlertAndAccept(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    // Dismiss Alert
    public void switchToAlertAndDismiss(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    // Get Alert Text
    public String switchToAlertAndGetText(WebDriver driver) {
    	
       String text1 = driver.switchTo().alert().getText();
       return text1;
    }
    
 // Send Keys to Alert
    public void switchToAlertAndSendKeys(WebDriver driver, String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    // Select Dropdown by Index
    public void select(WebElement element, int index) {
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }
 // Select Dropdown by Value
    public void select(WebElement element, String value) {
        Select sel = new Select(element);
        sel.selectByValue(value);
    }
 // Select Dropdown by Visible Text
    public void select(String text, WebElement element) {
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    // Mouse Hover on Element
    public void mouseHoverOnWebElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    // Double Click on Element
    public void doubleClick(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.doubleClick(element).perform();
    }
    // Right Click Method
    public void rightClick(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.contextClick(element).perform();
    }
    // Drag and Drop Method
    public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions act = new Actions(driver);
        act.dragAndDrop(source, target).perform();
    }
    // Window Maximize
    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }
    
    // Scroll Into View
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    
    

}
