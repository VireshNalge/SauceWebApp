package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	 // Constructor
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']")
    private WebElement prodName;

    @FindBy(xpath = "//div[text()='Sauce Labs Onesie']")
    private WebElement prodName1;

    @FindBy(id = "add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getProdName1() {
		return prodName1;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}
    
    

}
