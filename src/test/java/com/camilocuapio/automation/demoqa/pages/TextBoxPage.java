package com.camilocuapio.automation.demoqa.pages;

import com.camilocuapio.automation.demoqa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends Base {


    //Item locator
    By fullNameLocator = By.xpath("//*[@id='userName']");
    By emailLocator = By.xpath("//*[@id='userEmail']");
    By currentAddress = By.cssSelector("#currentAddress");
    By permanentAddress = By.cssSelector("#permanentAddress");
    By submit = By.cssSelector("#submit");

    By outputName = By.id("name");
    By outputEmail = By.id("email");
    By outputCurrentAddress = By.id("currentAddress");
    By outputPermananetAddress = By.id("permanentAddress");


    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void textBoxForm() {
        type("Camilo Cuapio", fullNameLocator);
        type("cuapio.cami@gmail.com", emailLocator);
        type("Ciudad Nezahualcoyotl", currentAddress);
        type("Estado de Mexico", permanentAddress);
    }

    public void clickSubmit() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
        click(submit);
    }

    public String getOutputName() {
        return findElement(outputName).getText();
    }

    public String getOutputEmail() {
        return findElement(outputEmail).getText();
    }

    public String getOutputCurrentAddress(){
        return findElement(outputCurrentAddress).getText();
    }
    public String getOutputPermananetAddress(){
        return findElement(outputPermananetAddress).getText();
    }
}
