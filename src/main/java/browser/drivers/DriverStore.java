package browser.drivers;

import browser.BrowserFactory;
import browser.Browsers;
import org.openqa.selenium.WebDriver;

public class DriverStore {
    private static WebDriver driver;

    private DriverStore() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new BrowserFactory().initDriver(Browsers.CHROME);
        }
        return driver;
    }
}
