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
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    protected void visit(String url) {
        driver.get(url);
    }

    protected void scroll(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
    }
}