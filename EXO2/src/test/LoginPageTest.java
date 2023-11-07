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

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginPageTest {
    WebDriver webDriver = new EdgeDriver();
    @BeforeEach
    public void setUpBeforeClass(){
        webDriver.get("http://51.83.167.193:8080/");
    }

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterLoginValues("nabil","test");
        loginPage.submitLoginForm();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        WebElement result = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
        assertEquals("Recherche",result.getText());
    }

    @Test
    public void loginTestFail(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterLoginValues("nabil","nabil");
        loginPage.submitLoginForm();

        //Change it to "Les identifications sont erronées" if your browser is in French
        assertEquals("Bad credentials" , loginPage.getErrorMessage());
    }
}