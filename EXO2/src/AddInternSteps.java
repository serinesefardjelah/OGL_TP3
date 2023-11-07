import io.cucumber.datatable.DataTable;
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
import test.AddInternPage;
import test.Intern;
import test.LoginPage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddInternSteps {
    private WebDriver webDriver = new EdgeDriver();
    private AddInternPage addInternPage;
    @Given("a successful Login")
    public void aSuccessfulLogin() {
        webDriver.get("http://51.83.167.193:8080/");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterLoginValues("nabil","test");
        loginPage.submitLoginForm();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        WebElement result = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));

    }

    @When("I click on Add a new Intern")
    public void iClickOnAddANewIntern() {
        WebDriverWait webDriverWait2 = new WebDriverWait(webDriver,Duration.ofSeconds(2));
        WebElement addInternButton = webDriverWait2.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Nouveau Stagiaire")));
        addInternButton.click();
//        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
//        WebElement result = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

    }

    @And("I enter a valid Intern data")
    public void iAddAValidInterData(DataTable dataTable) {
        List<Map<String,String>> internData = dataTable.asMaps(String.class,String.class);
        Map<String,String> internMap = internData.get(0);
         addInternPage = new AddInternPage(webDriver);
        Intern intern;
        intern = new Intern(
                internMap.get("civilValue"),
                internMap.get("lastName"),
                internMap.get("firstName"),
                internMap.get("address"),
                internMap.get("birthDate"),
                internMap.get("birthCountry"),
                internMap.get("birthCity"),
                internMap.get("company"),
                internMap.get("email"),
                internMap.get("phone"),
                internMap.get("lastNameAr"),
                internMap.get("firstNameAr"),
                internMap.get("birthCityAr")
        );

        System.out.println(internData.get(0).get("civilValue"));
        System.out.println(internData.get(0).get("birthCountry"));
        System.out.println(internData.get(0).get("company"));
        System.out.println("M");

        addInternPage.enterInterValues(intern);

        }


    @And("click Submit")
    public void clickSubmit() {
        addInternPage.submitAddIntern();
    }

    @Then("The Intern should be added")
    public void theInternShouldBeAdded() {
        assertEquals("Zouambia",addInternPage.getAddedLastName());
        assertEquals("Sohaib",addInternPage.getAddedFirstName());
        assertEquals("كمال",addInternPage.getAddedFirstNameAr());
        assertEquals("بروثن",addInternPage.getAddedLastNameAr());
        assertEquals("NOLIS",addInternPage.getAddedCompany());
    }


}
