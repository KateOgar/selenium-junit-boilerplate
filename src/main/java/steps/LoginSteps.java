package steps;

import annotations.Driver;
import annotations.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;
import page.MainPage;

import java.time.Duration;

public class LoginSteps {

    @Driver
    private WebDriver driver;

    @Page
    private MainPage mainPage;

    @Page
    private LoginPage loginPage;

    public LoginSteps goToLoginPage() {
        mainPage.signInLinkClick();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElements(loginPage.getPageLoaded()));
        return this;
    }

}
