package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

   WebDriver driver;


    By username = By.xpath("//form[@id=\"login-form\"]//input[@ng-model=\"user.name\"]");
    By password = By.xpath("//form[@id=\"login-form\"]//input[@ng-model=\"user.password\"]");
    By submit =   By.xpath("//button[@class=\"main-button\"]");
    By message =  By.xpath("//p[@class=\"error-message ng-binding\"]");
    By greeting = By.id("greetings");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public void setUserName(String strUsername){

        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(strUsername);

    }

    public void setPassword(String strPassword){

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(strPassword);

    }

    public void clickSubmit(){

        driver.findElement(submit).click();
    }

    public String getInvalidMessage(){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(message,"Invalid username or password!"));
        return driver.findElement(message).getText();
    }

    public String getGreeting(){

        return driver.findElement(greeting).getText();
    }


    public void login(String strUsername, String strPassword){

        this.setUserName(strUsername);
        this.setPassword(strPassword);
        this.clickSubmit();
}

}
