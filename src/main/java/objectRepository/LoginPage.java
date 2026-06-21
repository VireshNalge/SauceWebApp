package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	// Constructor
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	 @FindBy(id = "user-name")
	    private WebElement user;

	    @FindBy(id = "password")
	    private WebElement pwd;

	    @FindBy(id = "login-button")
	    private WebElement loginBtn;

		public WebElement getUser() {
			return user;
		}

		public WebElement getPwd() {
			return pwd;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}

}
