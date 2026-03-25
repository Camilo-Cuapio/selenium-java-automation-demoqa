package com.camilocuapio.automation.demoqa.pages;

import com.camilocuapio.automation.demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {


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

    public TextBoxPage open() {
        visit("https://demoqa.com/text-box");
        return this;
    }

    public TextBoxPage enterFullName(String name) {
        type(fullNameLocator, name);
        return this;
    }

    public TextBoxPage enterEmail(String mail) {
        type(emailLocator, mail);
        return this;
    }

    public TextBoxPage submitForm() {
        scroll(0, 300);
        click(submit);
        return this;
    }

    public String getSubmittedName() {
        return find(outputName).getText();
    }
}