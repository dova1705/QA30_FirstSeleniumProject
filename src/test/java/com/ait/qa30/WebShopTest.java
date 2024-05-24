package com.ait.qa30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebShopTest {
    //поле
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        // maximize browser to window
        driver.manage().window().maximize();
        // wait for all elements on the website to load before starting the test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCss() {
        WebElement element = driver.findElement(By.cssSelector("#flyout-cart"));
        driver.findElement(By.cssSelector(".ico-login"));
        // atribut - parametr == [atribut='parametr']
        driver.findElement(By.cssSelector("[role='status']"));
    }

    @Test
    public void findElementByXpath() {
        // id == //tag[@id='par'] вместо tag можно *
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        // className == //tag[@class='par']
        driver.findElement(By.xpath("//*[@class='top-menu']"));
        // contains //tag[contains(.,'Text')]
        //driver.findElement(By.xpath("//*[contains(.,'Genuine Leather Handbag with Cell Phone Holder & Many Pockets')]"));
        driver.findElement(By.xpath("//*[text()='Digital downloads']"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
