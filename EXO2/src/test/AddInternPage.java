package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddInternPage extends PageObject {
   @FindBy(id = "civility") private WebElement tempCivil ;
   private final Select civilStatus ;

   @FindBy(id="birthCountry.countryCode") private WebElement tempBirthCountry;
   private final Select birthCountry ;

   @FindBy(id="idCompany") private WebElement tempCompany;
   private final Select companyIntern ;

    @FindBy(id = "firstName") private WebElement firstNameIntern;
    @FindBy(id = "lastName") private WebElement lastNameIntern;
    @FindBy(id = "address") private WebElement addressIntern;
    @FindBy(id = "txtDate") private WebElement birthDateIntern;
    @FindBy(id = "birthCity") private WebElement birthCity;
    @FindBy(id = "email") private WebElement emailIntern;
    @FindBy(id = "phone") private WebElement phoneIntern;
    @FindBy(id = "lastNameAr") private WebElement lastNameAr;
    @FindBy(id = "firstNameAr") private WebElement firstNameAr;
    @FindBy(id = "birthCityAr") private WebElement birthCityAr;

    private final WebDriverWait webDriverWaitInter ;


    public void enterInterValues(Intern intern){


        this.lastNameIntern.sendKeys(intern.getLastName());
        this.firstNameIntern.sendKeys(intern.getFirstName());
        this.civilStatus.selectByValue(intern.getCivilValue());
        this.addressIntern.sendKeys(intern.getAddress());
        this.birthDateIntern.sendKeys(intern.getBirthDate());
        this.birthCountry.selectByValue(intern.getBirthCountry());
        this.birthCity.sendKeys(intern.getBirthCity());
        this.companyIntern.selectByValue(intern.getCompany());
        this.emailIntern.sendKeys(intern.getEmail());
        this.phoneIntern.sendKeys(intern.getPhone());
        this.lastNameAr.sendKeys(intern.getLastNameAr());
        this.firstNameAr.sendKeys(intern.getFirstNameAr());
        this.birthCityAr.sendKeys(intern.getBirthCityAr());
    }

    public void submitAddIntern(){
        this.firstNameIntern.submit();
    }


    public AddInternPage(WebDriver webDriver){

        super(webDriver);
        civilStatus = new Select(tempCivil);

        birthCountry = new Select(tempBirthCountry);
        companyIntern = new Select(tempCompany);
        webDriverWaitInter = new WebDriverWait(webDriver,Duration.ofSeconds(6));

    }
    public String getAddedLastName(){
        WebElement addedLastName = webDriverWaitInter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody tr:last-child td:nth-child(2)")));
        return  addedLastName.getText();
    }
    public String getAddedFirstName(){
        WebElement addedFirstName = webDriverWaitInter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody tr:last-child td:nth-child(3)")));
        return addedFirstName.getText();
    }
    public String getAddedLastNameAr(){
        WebElement addedLastNameAr = webDriverWaitInter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody tr:last-child td:nth-child(4)")));
        return addedLastNameAr.getText();
    }
    public String getAddedFirstNameAr(){
        WebElement addedFirstNameAr = webDriverWaitInter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody tr:last-child td:nth-child(5)")));

        return addedFirstNameAr.getText();
    }
    public String getAddedCompany(){
        WebElement addedCompany = webDriverWaitInter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("table tbody tr:last-child td:nth-child(6)")));
        return addedCompany.getText();
    }

    public boolean errorMessageLastNameIsDisplayed(){
        WebElement errorMessageLastName = webDriverWaitInter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lastName + span")));
        return errorMessageLastName.isDisplayed();
    }

    public  boolean errorMessageFirstNameIsDisplayed(){
        WebElement errorMessageFirstName = webDriverWaitInter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstName + span")));
        return errorMessageFirstName.isDisplayed();
    }
}
