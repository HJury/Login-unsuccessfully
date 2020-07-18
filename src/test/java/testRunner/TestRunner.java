package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This a Runner class and sets down the configuration for cucumber as the implementation of the ExtentReport
 *
 */
@CucumberOptions(
        features = "src/test/resources/functionalTestsFeatures/Login.feature",
        glue = "stepDefinitions", tags = {"@EXECUTE"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"},
        snippets = SnippetType.CAMELCASE
)

/**
 * Will run the cucumber feature
 */
@Test
public class TestRunner extends AbstractTestNGCucumberTests {
    static public String browser = "";

    @Parameters("browser")
    @BeforeClass
    public void setBrowser(String browserName) {
        browser = browserName;
    } //This method will set the value of the browser variable in order to know which browser should be opened
}


