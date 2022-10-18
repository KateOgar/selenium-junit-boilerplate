package browser;

import browser.drivers.ChromeDriverFactory;
import browser.drivers.FireFoxDriverFactory;
import org.openqa.selenium.WebDriver;
import util.NoSuchBrowserExeption;

import java.time.Duration;

public class BrowserFactory {

    public WebDriver initDriver(Browsers browser) throws NoSuchBrowserExeption {
        WebDriver driver = null;

        switch (browser) {
            case CHROME:
                driver = new ChromeDriverFactory().createDriver();
                break;
            case SAFARI:
                driver = new FireFoxDriverFactory().createDriver();
            default:
                throw new NoSuchBrowserExeption("There is no such browser!");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
        return driver;
    }
}
