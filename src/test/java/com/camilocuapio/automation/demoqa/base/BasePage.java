package com.camilocuapio.automation.demoqa.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            // fallback con JS (clave para DemoQA)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    protected void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    protected void visit(String url) {
        driver.get(url);
    }

    protected void scrollToElement(By locator) {
        WebElement element = find(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );
    }
}