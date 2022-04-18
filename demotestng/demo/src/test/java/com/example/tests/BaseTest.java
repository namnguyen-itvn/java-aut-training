package com.example.tests;

import java.util.concurrent.TimeUnit;

import com.example.core.configuration.Configuration;
import com.example.core.driver.DriverFactory;
import com.example.core.keyword.WebKeyword;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    public WebDriver driver;
    public WebKeyword keyword;
    public Configuration config;

    @BeforeMethod
    public void setUp() throws Exception {
        this.config = new Configuration("src/test/java/com/example/core/configuration/config.properties");
        this.driver = DriverFactory.getDriver(config.getProperty("browser"));
        this.keyword = new WebKeyword(this.driver);
        keyword.openUrl(config.getProperty("url"));
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }

}
