package util.props;

import org.aeonbits.owner.Config;
@Config.Sources({ "classpath:config.properties" })
public interface ConfigProp extends Config {
    @Key("local.run")
    @DefaultValue("true")
    boolean localRun();

    @Key("screenshots.dir")
    @DefaultValue("target/screenshots")
    String screenshotDir();
    @Key("base.url")
    String baseUrl();

    @Key("base.report.path")
    @DefaultValue("target/Spark.html")
    String reportPath();
}
