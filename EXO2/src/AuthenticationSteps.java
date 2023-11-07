import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticationSteps {
    private WebDriver webDriver = new EdgeDriver();
    private LoginPage loginPage;
    @Given("the web page")
    public void theWebPage() {
        webDriver.get("http://51.83.167.193:8080/");
    }

    @When("i enter {string} and {string}")
    public void iEnterAnd(String arg0, String arg1) {
        loginPage = new LoginPage(webDriver);
        loginPage.enterLoginValues(arg0,arg1);
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        loginPage.submitLoginForm();
    }

    @Then("i should access the page")
    public void iShouldAccessThePage() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        WebElement result = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
        assertEquals("Recherche",result.getText());
    }

    @Then("i should not access the page")
    public void iShouldNotAccessThePage() {
        //Change it to "Les identifications sont erronées" if your browser is in French
        assertEquals("Les identifications sont erronées" , loginPage.getErrorMessage());
        //assertEquals("Bad credentials" , loginPage.getErrorMessage());
    }


}
