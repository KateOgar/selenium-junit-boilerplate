package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;
    public static final String SIGN_IN_URL = "https://github.com/login";

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
