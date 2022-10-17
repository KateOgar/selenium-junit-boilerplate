package extensions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.extension.*;
import report.ReportManager;
import util.props.ConfigProp;

public class ReportTestWatcherExtension implements TestWatcher, BeforeAllCallback, BeforeEachCallback {

    private static ExtentReports extent = null;
    private ExtentTest test = null;

    private ConfigProp cfg = ConfigFactory.create(ConfigProp.class);

    @Override
    public void beforeAll(ExtensionContext context) {
        extent = ReportManager.getManager().getReport();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        test = extent.createTest(context.getRequiredTestMethod().getName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String fileName = new ScreenshotOnFailExtension().getTestName(context);
        test.log(Status.FAIL, context.getDisplayName())
                .fail(cause)
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(String.format("%s.png", fileName)).build());
        extent.flush();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        test.log(Status.PASS, "Test passed!");
        extent.flush();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String fileName = new ScreenshotOnFailExtension().getTestName(context);
        test.log(Status.FAIL, context.getDisplayName())
                .fail(cause)
                .fail(MediaEntityBuilder.createScreenCaptureFromPath(String.format("%s.png", fileName)).build());
        extent.flush();
    }
}
