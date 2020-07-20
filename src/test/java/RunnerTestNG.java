import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"},
        strict = true
)

public class RunnerTestNG extends AbstractTestNGCucumberTests {
}
