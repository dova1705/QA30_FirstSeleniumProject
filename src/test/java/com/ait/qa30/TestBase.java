package com.ait.qa30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {
    static WebDriver driver;

    //@BeforeMethod
    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //@AfterMethod
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickOnLogOut() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/register']"));
    }

    public void clickOnRegisterButton() {
        click(By.name("register-button"));
    }

    public void fillRegisterForm(String name, String lastname, String email, String password) {
        type(By.name("FirstName"), name);
        //enter lastname
        type(By.name("LastName"), lastname);
        //enter email
        type(By.name("Email"), email);
        //enter password
        type(By.name("Password"), password);
        //enter Confirm Password
        type(By.name("ConfirmPassword"), password);
    }

    public void clickOnLogIn() {
        click(By.cssSelector("[type='submit']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.name("Email"), email);
        //enter password
        type(By.name("Password"), password);
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

//    public boolean isAlertPresent() {
//        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)) //WebDriverWait - явное ожидание
//                .until(ExpectedConditions.alertIsPresent()); //сколько ждем
//        if (alert == null){
//            return false;
//        } else {
//            alert.accept();
//            return true;
//        }
//    }
}
