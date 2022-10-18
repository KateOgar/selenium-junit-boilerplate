package extensions;

import browser.drivers.DriverStore;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import util.NoSuchBrowserExeption;
import util.reflection.Injector;

import java.util.Optional;

public class DriverLifeCycleExtension implements BeforeAllCallback, AfterAllCallback {
    private static WebDriver driver;

    static {
        try {
            driver = DriverStore.getDriver();
        } catch (NoSuchBrowserExeption e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public DriverLifeCycleExtension() {
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        Optional<Object> testInstance = context.getTestInstance();

        testInstance.ifPresent(
                i -> {
                    try {
                        Injector.inject(i, driver);
                    } catch (NoSuchBrowserExeption e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }
        );
    }

    @Override
    public void afterAll(ExtensionContext context) {
        driver.quit();
    }
}
