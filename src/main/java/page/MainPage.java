package page;

import annotations.Driver;
import extensions.DriverLifeCycleExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@ExtendWith({DriverLifeCycleExtension.class})
public class MainPage implements Page{

    @Driver
    private WebDriver driver;

    @FindBy(className = "HeaderMenu-link--sign-up")
    private WebElement loginLink;

    @FindBy(className = "HeaderMenu-link--sign-in")
    private WebElement signInLink;

    public void loginLinkClick() {
        loginLink.click();
    }

    public void signInLinkClick() {
        signInLink.click();
    }

    @Override
    public WebElement[] getPageLoaded(){
        return new WebElement[]{loginLink, signInLink};
    }
}
