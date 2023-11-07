import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "EXO2/Features",plugin ={"pretty","html:reports/report2.html"})

public class TestExo2 {

}
