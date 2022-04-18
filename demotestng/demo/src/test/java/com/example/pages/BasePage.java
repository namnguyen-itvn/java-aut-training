package com.example.pages;

import com.example.core.keyword.WebKeyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebKeyword keyword;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.keyword = new WebKeyword(driver);
        this.wait = new WebDriverWait(driver, 60);
    }

}
