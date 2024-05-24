package com.ait.qa30;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()){
            clickOnLogOut();
        }
    }

    @Test
    public void createNewAccountPositiveTest(){
        //click on Login link
        clickOnRegisterLink();
        //enter firstname
        fillRegisterForm("Mike", "Smith", "mike@gm.com", "Mike1234$");
        //click on register button
        clickOnRegisterButton();
        //assert Alert is appeared
        //Assert.assertTrue(isAlertPresent());
    }

}
