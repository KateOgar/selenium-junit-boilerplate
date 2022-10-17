package steps;

import annotations.Driver;
import annotations.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;

import java.time.Duration;

public class MainPageSteps {

    @Driver
    private WebDriver driver;

    @Page
    private MainPage mainPage;

    public MainPageSteps goToLoginPage() {
        mainPage.signInLinkClick();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElements(mainPage.getPageLoaded()));
        return this;
    }

}
