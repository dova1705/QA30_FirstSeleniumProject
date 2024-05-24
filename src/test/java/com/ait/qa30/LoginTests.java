package com.ait.qa30;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!isElementPresent(By.cssSelector("[href='/login']"))){
            clickOnLogOut();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest(){
        //click on Login link
        clickOnRegisterLink();
        //enter email
        fillLoginForm("mike@gm.com", "Mike1234$");
        //click on log in
        clickOnLogIn();
        //Assert Log Out
        //Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']"))); // не понимаю надо повторить!!!
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/login']"));
    }
}
