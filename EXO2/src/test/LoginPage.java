package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageObject {
    @FindBy(id = "username") private WebElement userNameInput;
    @FindBy(id = "password") private WebElement passwordInput;
    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void enterLoginValues(String userName, String password){
        this.userNameInput.sendKeys(userName);
        this.passwordInput.sendKeys(password);
    }

    public void submitLoginForm(){
        this.passwordInput.submit();
    }

    public String getErrorMessage(){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h4"))).getText();
    }
}
