package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    WebDriver driver;

    By logout = By.xpath("//div[@class=\"header-container\"]/p[@class=\"main-button\"]");
    By create    = By.id("bAdd");

    public MainPage(WebDriver driver){

        this.driver = driver;

    }

    public void logout(){ driver.findElement(logout).click(); }

    public void clickCreate(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(create));
        driver.findElement(create).click();

    }

    public void selectEmployee(String name){

        String employeeSelect = "//*[@id=\"employee-list\"]/li[contains(text(),'"+name+"')]";
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.xpath(employeeSelect))).perform();

    }
}

