package tests;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.*;

public class TestExecution {

    public WebDriver driver;
    LoginPage newLogin;
    CreatePage createPage;
    UpdatePage updatePage;
    MainPage mainPage;
    Boolean login = false;
    Boolean isEmployeeCreated = false;

    @BeforeClass
    public void startBrowser() {

        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://cafetownsend-angular-rails.herokuapp.com/login");
    }

    @AfterClass
    public void logoutAndCloseBrowser(){
        if (login)
            correctLogout();
    }

    @DataProvider(name = "invalidLogin")
    public static Object[][] invalidCredentials() {

        return new Object[][] {{ "test", "Skywalker" },
                               { "Luke", "test"      },
                               { "Luke", ""          },
                               {  ""   , "Skywalker" }};
    }

    @Test(dataProvider = "invalidLogin",priority = 0)
    public void invalidLogin(String sUsername,String sPassword) throws InterruptedException {

        newLogin = new LoginPage(driver);
        newLogin.login(sUsername,sPassword);
        Assert.assertEquals(newLogin.getInvalidMessage(),"Invalid username or password!");
        System.out.println("Invalid Login. Details Username ="+sUsername+" and Password = "+sPassword);
    }

    @Test (priority = 1)
    public void validLogin() {

        newLogin = new LoginPage(driver);
        newLogin.login("Luke","Skywalker");
        Assert.assertEquals(newLogin.getGreeting(),"Hello Luke");
        System.out.println("Login successful.");
        login = true;
    }

    @DataProvider(name = "invalidCreateEmployee")
    public static Object[][] invalidEmployee() {

        return new Object[][] { {"Selenium", "", "2018-01-01", "a@b.cam"},
                                {"", "Test", "2018-01-01", "a@b.cam"},
                                {"Selenium", "Test", "", "a@b.cam"},
                                {"Selenium", "Test", "2018-01-01", "ab.cam"}};

    }

    @Test (dataProvider="invalidCreateEmployee", priority = 2)
    public void invalidCreateEmployee (String fName, String lName, String sDate, String email)throws InterruptedException{
        if (!login)
            validLogin();
        createPage = new CreatePage(driver);
        mainPage = new MainPage(driver);
        mainPage.clickCreate();
        createPage.setDetails(fName,lName,sDate,email);
        createPage.clickAdd();
        Thread.sleep(5000);
        Assert.assertTrue(createPage.errorCreate());
        System.out.println("Invalid Create. Details First Name ="+fName+" and Last Name = "+lName+" Start Date = "+sDate+" Email = "+email);
        createPage.clickCancel();
    }

    @Test (priority = 3)
    public void createEmployee(){
        if (!login)
            validLogin();
        createPage = new CreatePage(driver);
        mainPage = new MainPage(driver);
        mainPage.clickCreate();
        createPage.setDetails("Selenium","Test","2018-01-01","a@b.cam");
        createPage.clickAdd();
        Assert.assertTrue(createPage.confirmCreate());
        System.out.println("Create Employee successful.");
        isEmployeeCreated = true;
    }

    @Test (priority = 4)
    public void updateEmployee(){
        if (!isEmployeeCreated)
            createEmployee();
        updatePage = new UpdatePage(driver);
        mainPage.selectEmployee("Selenium");
        updatePage.setDetails("Selenium1","Test","2018-01-01","a@b.cam");
        updatePage.clickUpdate();
        Assert.assertTrue(updatePage.confirmCreate());
        System.out.println("Update Employee successful.");
    }

    @Test (priority = 5)
    public void deleteEmployee(){
        if (!isEmployeeCreated)
            createEmployee();
        mainPage.selectEmployee("Selenium");
        updatePage = new UpdatePage(driver);
        updatePage.clickDelete();
        Assert.assertTrue(updatePage.confirmCreate());
        System.out.println("Delete Employee successful.");
    }

    @Test(priority = 6)
    public void correctLogout(){
        if (!login)
            validLogin();
        mainPage = new MainPage(driver);
        mainPage.logout();
        System.out.println("Logout successful.");
        driver.close();
        driver.quit();
        login = false;
    }
}
