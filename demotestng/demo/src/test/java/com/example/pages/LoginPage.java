package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // private String txtEmail = "//input[@id='username']";

    public WebElement txtEmail = keyword.findElement(By.xpath("//input[@id='username']"));
    public WebElement txtPassword = keyword.findElement(By.xpath("//input[@id='password']"));
    public WebElement btnLogin = keyword.findElement(By.xpath("//input[@value='Login']"));

    public LoginPage loginWithUserNameAndPassword(String userName, String passWord) throws Exception {
        // txtEmail.sendKeys(userName);
        keyword.setText(txtEmail, userName);
        // txtPassword.sendKeys(passWord);
        keyword.setText(txtPassword, passWord);
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
        return this;
    }
}
