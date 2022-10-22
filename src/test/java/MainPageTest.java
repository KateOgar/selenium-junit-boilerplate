import annotations.Driver;
import annotations.Page;
import annotations.Steps;
import extensions.DriverLifeCycleExtension;
import extensions.ReportTestWatcherExtension;
import extensions.ScreenshotOnFailExtension;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import page.MainPage;
import steps.LoginSteps;
import util.props.ConfigProp;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static page.SignInPage.SIGN_IN_URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({DriverLifeCycleExtension.class, ReportTestWatcherExtension.class, ScreenshotOnFailExtension.class})
public class MainPageTest {

    @Driver
    private WebDriver driver;

    @Page
    private MainPage mainPage;
    @Steps
    private LoginSteps onMainPage;

    private ConfigProp cfg = ConfigFactory.create(ConfigProp.class);

    @Test
    public void signInGoesToLoginPage() {
        driver.get(cfg.baseUrl());
        onMainPage.goToLoginPage();

        String URL = driver.getCurrentUrl();
        System.out.println("URL" + URL);
        assertThat(URL, is(SIGN_IN_URL));
    }
}
