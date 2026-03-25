package com.camilocuapio.automation.demoqa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
    }
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public WebDriver chromeDriverConnection() {
        try {

            // Prepare the compatible ChromeDriver
            WebDriverManager.chromedriver().setup();

            // ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            //// Configure Chrome to run with a clean profile for automation.
            //// Disables notifications, infobars, and password manager features
            //// (including password leak detection) to prevent pop-ups or interruptions.

            options.addArguments("--incognito"); // clean session
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-features=PasswordLeakDetection");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);
            //---------------


            driver = new ChromeDriver(options);

        } catch (Exception e) {
            e.printStackTrace();
            driver = null; // Avoid NPE if the session fails.
        }
        return driver;
    }

    public void visit(String url){
        driver.get(url);
    }
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
}
