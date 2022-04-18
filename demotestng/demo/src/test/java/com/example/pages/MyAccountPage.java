package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    // #region Define Elemen Locator
    private WebElement lblWelcomeMessage = driver
            .findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]"));
    private WebElement lblWelcomeMessageContent = driver
            .findElement(By.xpath("(//div[@class='woocommerce-MyAccount-content']//p)[last()]"));
    // #endregion

    // #region Define Function/Action

    // Get Welcome Message Text
    public String getWelcomeMessage() {
        return lblWelcomeMessage.getText();
    }

    // Get Welcome Message Content Text
    public String getWelcomeMessageContent() {
        return lblWelcomeMessageContent.getText();
    }

    public String expectedMessage = "Hello namnguyen.pro (not namnguyen.pro? Sign out)";
    public String expectedMessageContext = "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.";

    public boolean isMessageCorrect() {
        if (getWelcomeMessage().equals(expectedMessage)) {
            return true;
        }

        else {
            return false;
        }
    }
    // #endregion

}
