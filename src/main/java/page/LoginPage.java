package page;

import annotations.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage implements Page{

    @Driver
    private WebDriver driver;

    @FindBy(className = "auth-form-header")
    private WebElement signInHeader;

    @FindBy(className = "js-sign-in-button")
    private WebElement signInButton;

    @Override
    public WebElement[] getPageLoaded(){
        return new WebElement[]{signInHeader, signInButton};
    }
}
