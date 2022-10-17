package extensions;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import util.props.ConfigProp;


import java.io.File;
import java.io.IOException;

import static browser.drivers.DriverStore.getDriver;

public class ScreenshotOnFailExtension implements TestWatcher {

    private ConfigProp cfg = ConfigFactory.create(ConfigProp.class);
    private final File SCREENSHOT_PATH = new File(cfg.screenshotDir());

    public ScreenshotOnFailExtension() {
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String fileName = getTestName(context);
        try {
            FileUtils.deleteDirectory(SCREENSHOT_PATH);
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE); // make the screenshot
            FileUtils.copyFile(scrFile, new File(String.format("%s/%s.png", SCREENSHOT_PATH, fileName))); //rename it with test method
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failure: " + e.getMessage());
        }
    }

    public String getTestName(ExtensionContext context) {
        return context.getDisplayName().replaceAll("[()]", "");
    }

//    public byte[] getScreenshot(ExtensionContext context) {
//        String fileName = getTestName(context);
//
//        try {
//            FileUtils.deleteDirectory(SCREENSHOT_PATH);
//            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE); // make the screenshot
//            FileUtils.copyFile(scrFile, new File(String.format("%s/%s.png", SCREENSHOT_PATH, fileName))); //rename it with test method
//        } catch (IOException | WebDriverException e) {
//            System.out.println("screenshot failure: " + e.getMessage());
//        }
//        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
//    }
//
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshot(byte[] screenShot, ExtensionContext context) {
//        return getScreenshot(context);
//    }
}
