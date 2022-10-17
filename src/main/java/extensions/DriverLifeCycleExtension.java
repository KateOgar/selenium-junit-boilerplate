package extensions;

import browser.drivers.DriverStore;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import util.reflection.Injector;

import java.util.Optional;

public class DriverLifeCycleExtension implements BeforeAllCallback, AfterAllCallback {
    private static WebDriver driver = DriverStore.getDriver();

    public DriverLifeCycleExtension() {
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        Optional<Object> testInstance = context.getTestInstance();

        testInstance.ifPresent(
                i -> {
                    Injector.inject(i, driver);
                }
        );
    }

    @Override
    public void afterAll(ExtensionContext context) {
        driver.quit();
    }
}
