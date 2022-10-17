package browser.drivers;

import browser.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.props.ConfigProp;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverFactory implements Factory {

    @Override
    public WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = null;
        ConfigProp cfg = ConfigFactory.create(ConfigProp.class);

        if (cfg.localRun()) {
            driver = WebDriverManager.chromedriver().create();
        } else {
            try {
                driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444"), chromeOptions);
            } catch (MalformedURLException e) {
                System.out.println("can't create webdriver");
                throw new RuntimeException(e);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
}
