package browser.drivers;

import browser.BrowserFactory;
import browser.Browsers;
import org.openqa.selenium.WebDriver;
import util.NoSuchBrowserExeption;

public class DriverStore {
    private static WebDriver driver;

    private DriverStore() {
    }

    public static WebDriver getDriver() throws NoSuchBrowserExeption {
        if (driver == null) {
            driver = new BrowserFactory().initDriver(Browsers.CHROME);
        }
        return driver;
    }
}
