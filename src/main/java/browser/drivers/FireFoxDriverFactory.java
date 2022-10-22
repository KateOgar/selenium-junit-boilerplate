package browser.drivers;

import browser.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FireFoxDriverFactory implements Factory {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(FIREFOX).setup();

        return new FirefoxDriver();
    }
}
