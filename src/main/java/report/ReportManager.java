package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.aeonbits.owner.ConfigFactory;
import util.props.ConfigProp;

public class ReportManager {

    private static ReportManager manager = new ReportManager();
    private ExtentReports extent = new ExtentReports();
    private ConfigProp cfg = ConfigFactory.create(ConfigProp.class);
    private ExtentSparkReporter spark = new ExtentSparkReporter(cfg.reportPath());

    private ReportManager(){};

    public static ReportManager getManager() {
        return manager;
    }
    public ExtentReports getReport() {
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("MyPetProjectReport");
        extent.attachReporter(spark);
        return extent;
    }
}
