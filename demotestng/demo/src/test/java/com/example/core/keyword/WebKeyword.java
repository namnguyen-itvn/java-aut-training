package com.example.core.keyword;

import java.security.KeyStore.Entry.Attribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebKeyword {
    private WebDriver driver;
    private WebDriverWait wait;
    private int timeout = 30;

    public WebKeyword(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    /**
     * Method to check the url then opening the url
     * 
     * @param url website to open
     * @throws Exception Exception
     */
    public void openUrl(String url) throws Exception {
        if (!(url.startsWith("http://") || url.startsWith("https://"))) {
            throw new Exception("Invalid URL format");
        }
        driver.get(url);
    }

    /**
     * Method to wait element visible to located and get element by locator
     * 
     * @param locator element locator
     * @return element to be located
     */
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Get Value By AttributeValue
     * 
     * @elem locator element locator
     * @attributeValue that the value to get [value | innerText | outerText |
     *                 textContent | title]
     */
    public String getValueByAttributeValue(WebElement elem, String attributeValue) {
        try {
            return elem.getAttribute(attributeValue);
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not visible");
        }
    }

    /**
     * Clear text before setting text
     * 
     * @param elem element to set text
     * @param text value to set to element
     */
    public void setText(WebElement elem, String text) {
        try {
            elem.clear();
            elem.sendKeys(text);
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not enable to set text");
        }
    }

    /**
     * Scroll to the element before execute clicking.
     * 
     * @param elem
     */
    public void click(WebElement elem) {
        Actions actions = new Actions(this.driver);
        actions.moveToElement(elem).build().perform();
        elem.click();
    }

    public void select(WebElement element, SelectType type, String options) throws Exception {
        Select select = new Select(element);
        switch (type) {
            case SELECT_BY_INDEX:
                try {
                    select.selectByIndex(Integer.parseInt(options));
                } catch (Exception e) {
                    throw new Exception("Please input numberic on selectOption for SelectType.SelectByIndex");
                }
                break;
            case SELECT_BY_TEXT:
                select.selectByVisibleText(options);
                break;
            case SELECT_BY_VALUE:
                select.selectByValue(options);
                break;
            default:
                throw new Exception("Get error in using Selected");
        }
    }
}
