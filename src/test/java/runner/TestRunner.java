package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@auto and not @newSteps", 
        features = "src/test/java/features/",
        glue = {"base", "steps"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "html:target/index.html", "html:target/index.html" })

public class TestRunner {

}
