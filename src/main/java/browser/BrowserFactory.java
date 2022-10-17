package browser;

import browser.drivers.ChromeDriverFactory;
import browser.drivers.FireFoxDriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BrowserFactory {

    public WebDriver initDriver(Browsers browser) {
        WebDriver driver = null;

        switch (browser) {
            case CHROME:
                driver = new ChromeDriverFactory().createDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
                driver.manage().window().maximize();
                break;
            case SAFARI:
                driver = new FireFoxDriverFactory().createDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
                driver.manage().window().maximize();
            default:
                System.out.println("No such browser!");
        }
        return driver;
    }
}
