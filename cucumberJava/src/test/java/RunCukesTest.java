import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"src/test/java/stepdefs/Steps.java"},
        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"}
)

public class RunCukesTest {
}
