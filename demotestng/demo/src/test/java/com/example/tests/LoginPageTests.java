package com.example.tests;

import com.example.core.datadriven.AccountUnderTest;
import com.example.pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
    @Test(dataProvider = "AccountUnderTest", dataProviderClass = AccountUnderTest.class)
    public void verifyUserLoginSuccessllyTest(String username, String password) throws Exception {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.loginWithUserNameAndPassword(username, password);
        MyAccountPage myAccountPage = new MyAccountPage(this.driver);
        Assert.assertTrue(myAccountPage.isMessageCorrect());
    }
}