package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "steps",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    tags = "@Navigation"
)

public class TestRunner {
    @BeforeClass
    public static void maximizeScreen() {
        BasePage.maximizeWindow();
    }
    @AfterClass
    public static void killDriver() throws InterruptedException {
        //Thread.sleep(2000);
        BasePage.closeBrowser();
    }
}
