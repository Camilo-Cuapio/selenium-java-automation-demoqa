package com.camilocuapio.automation.demoqa.tests;

import com.camilocuapio.automation.demoqa.base.BaseTest;
import com.camilocuapio.automation.demoqa.pages.TextBoxPage;
import com.camilocuapio.automation.demoqa.utils.ScreenshotOnFailureExtension;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@Epic("DemoQA Automation")
@Feature("Text Box")
@ExtendWith({
        ScreenshotOnFailureExtension.class,
        io.qameta.allure.junit5.AllureJunit5.class
})
public class TextBoxTest extends BaseTest {

    @Test
    @DisplayName("Text box validation")
    @Description("Verify that text can be added to the Name, Email, Current Address, and Permanent Address fields")
    @Feature("Write in the text boxes")
    @Story("Text box")
    @Severity(SeverityLevel.CRITICAL)
    void TC_01_shouldSubmitFormSuccessfully() {
//Data to be entered
        String name = "Camilo Cuapio";
        String email = "Camilo@test.com";
        String currentAddress = "Cuarta Avenida 123";
        String permanentAddress = "Estado de mexico";

        TextBoxPage page = new TextBoxPage(driver);
//Call methods to enter values into the form
        page.open()
                .enterFullName(name)
                .enterEmail(email)
                .enterCurrentAddress(currentAddress)
                .enterPermanentAddress(permanentAddress)
                .submitForm();
//Get output data
        String resultName = page.getSubmittedName();
        String resultEmail = page.getSubmittedEmail();
        String resultCurrentAddress = page.getSubmittedCurrentAddress();
        String resultPermanentAddress = page.getSubmittedPermanentAddress();
//Print output data
        System.out.println("ResultName: " + resultName);
        System.out.println("ResultEmail: " + resultEmail);
        System.out.println("ResultCurrent: " + resultCurrentAddress);
        System.out.println("ResultPermanent: " + resultPermanentAddress);

//Input and output data validation
        assertTrue(resultName.equals(name));
        assertTrue(resultEmail.equals(email));
        assertTrue(resultCurrentAddress.equals(currentAddress));
        assertTrue(resultPermanentAddress.equals(permanentAddress));
    }
}
