package com.ait.qa30;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createNewAccountNegativeTest(){
        //click on Login link
        click(By.cssSelector("[href='/register']"));
        //enter firstname
        type(By.name("FirstName"), "Mike");
        //enter lastname
        type(By.name("LastName"), "Smith");
        //enter email
        type(By.name("Email"), "mike@gm.com");
        //enter password
        type(By.name("Password"), "Mike1234$");
        //enter Confirm Password
        type(By.name("ConfirmPassword"), "Mike1234$");
        //click on register button
        click(By.name("register-button"));
        //assert Alert is appeared
        Assert.assertTrue(isAlertPresent());
    }

}
