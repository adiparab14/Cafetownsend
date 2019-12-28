package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdatePage extends CreatePage {

    By update = By.xpath("//button[@class=\"main-button\"]");
    By delete = By.xpath("//div[@class=\"formFooter\"]/p[@class=\"main-button\"]");

    public UpdatePage(WebDriver driver){

        this.driver = driver;

    }


    public void clickUpdate(){
        driver.findElement(update).click();
    }

    public void clickDelete(){

        driver.findElement(delete).click();
        driver.switchTo().alert().accept();

    }
}
