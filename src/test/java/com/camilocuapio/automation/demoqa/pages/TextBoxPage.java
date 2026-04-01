package com.camilocuapio.automation.demoqa.pages;

import com.camilocuapio.automation.demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {
    //data locators to enter
    By fullNameLocator = By.id("userName");
    By emailLocator = By.id("userEmail");
    By currentAddressLocator = By.id("currentAddress");
    By permanentAddressLocator = By.id("permanentAddress");
    By submit = By.id("submit");
    //output locator
    By outputName = By.id("name");
    By outputEmail = By.id("email");
    By outputCurrentAdress = By.cssSelector("#output #currentAddress");
    By outputPermanentAddress = By.cssSelector("#output #permanentAddress");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    //navigation URL
    public TextBoxPage open() {
        visit("https://demoqa.com/text-box");
        return this;
    }

    //Enter name
    public TextBoxPage enterFullName(String name) {
        type(fullNameLocator, name);
        return this;
    }

    //Enter emeail
    public TextBoxPage enterEmail(String mail) {
        type(emailLocator, mail);
        return this;
    }

    //Enter current Address
    public TextBoxPage enterCurrentAddress(String currentAddress) {
        type(currentAddressLocator, currentAddress);
        return this;
    }

    //Enter Permanent Address
    public TextBoxPage enterPermanentAddress(String permanentAddress) {
        type(permanentAddressLocator, permanentAddress);
        return this;
    }

    //submit requested data
    public TextBoxPage submitForm() {
        scrollToElement(submit);
        click(submit);
        return this;
    }

    //Get name
    public String getSubmittedName() {
        return find(outputName).getText().replace("Name:", "").trim();

    }

    //Get email
    public String getSubmittedEmail() {
        return find(outputEmail).getText().replace("Email:", "").trim();
    }

    //Get Current address
    public String getSubmittedCurrentAddress() {
        return find(outputCurrentAdress).getText().replace("Current Address :", "").trim();
    }

    //get permanent address
    public String getSubmittedPermanentAddress() {
        return find(outputPermanentAddress).getText().replace("Permananet Address :", "").trim();
    }
}