package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoFindingElement extends BasePage{
    public DemoFindingElement(WebDriver driver) {
        super(driver);
    }

    private WebElement lblWelcomeMessage = driver
            .findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]"));
            
}
