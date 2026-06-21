package testCase;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import net.sourceforge.tess4j.Tesseract;

public class TC_03_HandlingCaptcha {

	public static void main(String[] args) throws Throwable {
		//WebDriver driver = new EdgeDriver();
		WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://yonobusiness.sbi.bank.in/yonobusinesslogin");
        driver.findElement(By.xpath("//span[contains(@class,'icon-cancel')]")).click();

        Thread.sleep(5000);

        // Capture captcha image
        WebElement captcha = driver.findElement(By.id("imageCaptcha"));

        File src = captcha.getScreenshotAs(OutputType.FILE);

        File dest = new File("./Screenshots/5_captcha.png");

        FileUtils.copyFile(src, dest);

        //  captcha using Tesseract OCR
        Tesseract tss = new Tesseract();

        tss.setDatapath("C:\\Users\\vires\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata"); 
        tss.setLanguage("eng");

        String text = tss.doOCR(dest);

        text = text.replaceAll(" ", "");
        text = text.replaceAll("\n", "");
        text = text.replaceAll("\\s+", "");
        text = text.replaceAll("[^A-Za-z0-9]", "");

        System.out.println("Captcha Text: " + text);
        

        // captcha text
        driver.findElement(By.id("Capchalogin")).sendKeys(text);

        Thread.sleep(5000);

//        driver.quit();
    }

	}


