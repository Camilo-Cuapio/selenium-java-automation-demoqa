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
    void shouldSubmitFormSuccessfully() {

        String name = "Camilo Cuapio";
        String mail = "Camilo@test.com";
        String currentAddress="Cuarta Avenida 123";
        String permanentAddress="Estado de mexico";

        TextBoxPage page = new TextBoxPage(driver);

        page.open()
                .enterFullName(name)
                .enterEmail(mail)

                .submitForm();

        String result = page.getSubmittedName();

        System.out.println("Result: " + result);

        assertTrue(result.contains(name));
    }
}
