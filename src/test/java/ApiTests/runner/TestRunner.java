package ApiTests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ApiTests/features/GetAllUsers.feature",
        glue = {"ApiTests/steps"}
)
public class TestRunner {
}