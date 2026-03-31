package com.camilocuapio.automation.demoqa.pages;

import com.camilocuapio.automation.demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {

    By fullNameLocator = By.id("userName");
    By emailLocator = By.id("userEmail");
    By currentAddressLocator = By.id("currentAddress");
    By permanentAddressLocator = By.id("permanentAddress");
    By submit = By.id("submit");

    By outputName = By.id("name");

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
    public TextBoxPage enterCurrentAddress(String currentAddress){
        type(currentAddressLocator,currentAddress);
        return this;
    }
    public TextBoxPage enterPermanentAddress(String permanentAddress){
        type(permanentAddressLocator,permanentAddress);
        return this;
    }

    public TextBoxPage submitForm() {
        scrollToElement(submit);
        click(submit);
        return this;
    }

    public String getSubmittedName() {
        return find(outputName).getText();
    }
}