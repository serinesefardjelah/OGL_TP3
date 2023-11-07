import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "EXO1/Features",plugin ={"pretty","html:reports.html"})

public class Test {

}
