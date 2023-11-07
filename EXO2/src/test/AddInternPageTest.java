package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddInternPageTest {

    WebDriver webDriver = new EdgeDriver();
    @BeforeEach
    public void setUpBeforeClass(){
        webDriver.get("http://51.83.167.193:8080/");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterLoginValues("nabil","test");
        loginPage.submitLoginForm();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        WebElement result = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
        WebDriverWait webDriverWait2 = new WebDriverWait(webDriver,Duration.ofSeconds(2));
        WebElement addInternButton = webDriverWait2.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Nouveau Stagiaire")));
        addInternButton.click();
    }
    @Test
    public void addValidIntern(){
        AddInternPage addInternPage = new AddInternPage(webDriver);
//        Optional<String> lastName = Optional.of("Zouambia");
//        Optional<String> firstName = Optional.of("Sohaib");
        Intern intern = new Intern("M", "Zouambia","Sohaib","Medea","2001-10-15","USA","New York","11","js_zouambia@esi.dz","05134891711","بروثن","كمال", "المدية");
        addInternPage.enterInterValues(intern);
        addInternPage.submitAddIntern();

        assertEquals("Zouambia",addInternPage.getAddedLastName());
        assertEquals("Sohaib",addInternPage.getAddedFirstName());
        assertEquals("كمال",addInternPage.getAddedFirstNameAr());
        assertEquals("بروثن",addInternPage.getAddedLastNameAr());
        assertEquals("NOLIS",addInternPage.getAddedCompany());
    }

    @Test
    public void addNotValidIntern(){
        AddInternPage addInternPage = new AddInternPage(webDriver);
        Optional<String> lastName = Optional.empty();
        Optional<String> firstName = Optional.empty();
        Intern intern = new Intern("M", "","","Medea","2001-10-15","USA","New York","11","js_zouambia@esi.dz","05134891711","بروثن","كمال", "المدية");
        addInternPage.enterInterValues(intern);
        addInternPage.submitAddIntern();

        assertTrue(addInternPage.errorMessageLastNameIsDisplayed());
        assertTrue(addInternPage.errorMessageFirstNameIsDisplayed());
    }
}