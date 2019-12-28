package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePage {

    WebDriver driver;


    By create   = By.id("bAdd");
    By cancel   = By.className("bCancel");
    By firstName = By.xpath("//form[@name=\"employeeForm\"]//input[@ng-model=\"selectedEmployee.firstName\"]");
    By lastName  = By.xpath("//form[@name=\"employeeForm\"]//input[@ng-model=\"selectedEmployee.lastName\"]");
    By startDate = By.xpath("//form[@name=\"employeeForm\"]//input[@ng-model=\"selectedEmployee.startDate\"]");
    By email     = By.xpath("//form[@name=\"employeeForm\"]//input[@ng-model=\"selectedEmployee.email\"]");
    By add       = By.xpath("//button[@class=\"main-button\"]");


    public CreatePage(){

    }
    public CreatePage(WebDriver driver){

        this.driver = driver;
    }

    public void setFirstName(String fName) {

        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);
    }

    public void setLastName(String lName) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(lastName).clear();
        wait.until(ExpectedConditions.elementToBeClickable(lastName));
        driver.findElement(lastName).sendKeys(lName);
    }

    public void setStartDate(String sDate) {

        driver.findElement(startDate).clear();
        driver.findElement(startDate).sendKeys(sDate);
    }

    public void setEmail(String sEmail) {

        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(sEmail);
    }

    public void clickAdd() {
        driver.findElement(add).click();
    }

    public void setDetails(String fName, String lName, String sDate, String email){
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setStartDate(sDate);
        this.setEmail(email);
    }



    public Boolean confirmCreate(){
        return driver.findElement(create).isDisplayed();
    }

    public void clickCancel(){
        driver.findElement(cancel).click();
    }

    public Boolean errorCreate(){
        return driver.findElement(add).isDisplayed();
    }

}
