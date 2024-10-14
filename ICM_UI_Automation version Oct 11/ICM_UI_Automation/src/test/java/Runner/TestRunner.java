package Runner;

import com.aventstack.extentreports.ExtentReports;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to feature files
        glue = "StepDefinition", // Package containing step definitions
        tags = "@akshay",
        plugin = {"html:target/cucumber-reports/report.html","json:target/cucumber-report.json"},
        publish = true
)

public class TestRunner {
    // Configuration details
    private static ExtentReports extentReports;
    private static ExtentHtmlReporter htmlReporter;

    public static WebDriver driver;
    public static String webURL = "https://dev.incredmoney.com/login/"; // URL for Navigation
    private static final String CHROME_DRIVER_PATH = "/home/kshitij/Downloads/chromedriver-linux64/chromedriver"; // ChromeDriver path

    static {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.setProperty("report.timestamp", timestamp);
    }

    @BeforeClass
    public static void setUp() {
        // Set the path to the WebDriver executable
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:loggingPrefs", Collections.singletonMap("browser", Level.ALL));

        // Initialize WebDriver (Chrome in this case)
        driver = new ChromeDriver();

        Logs logs = driver.manage().logs();
        LogEntries logEntries = logs.get("browser");
        for (LogEntry entry : logEntries) {
            System.out.println("Console log: " + entry.getMessage());

            ChromeOptions optionss = new ChromeOptions();
            options.setCapability("goog:loggingPrefs", Collections.singletonMap("browser", Level.ALL));
            driver = new ChromeDriver(optionss);

        }

        htmlReporter = new ExtentHtmlReporter("target/cucumber-reports/report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    // You might also want to include a @AfterClass method to quit the driver if needed
     @AfterClass
     public static void tearDown() {

         Logs logs = driver.manage().logs();
         LogEntries logEntries = logs.get("browser");

         for (LogEntry entry : logEntries) {
             System.out.println("Console log: " + entry.getMessage());
         }
         if (driver != null) {
             driver.quit();
         }
         extentReports.flush();
     }
/*
    public WebDriver getDriver() {
        return driver;
    }*/

}