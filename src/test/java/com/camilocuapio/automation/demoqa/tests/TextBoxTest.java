package com.camilocuapio.automation.demoqa.tests;

import com.camilocuapio.automation.demoqa.base.BaseTest;
import com.camilocuapio.automation.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextBoxTest extends BaseTest {

    @Test
    void shouldSubmitFormSuccessfully() {

        // Arrange
        String name = "Juan Perez";

        TextBoxPage page = new TextBoxPage(driver);

        // Act
        page.open()
                .enterFullName(name)
                .enterEmail("juan@test.com")
                .submitForm();

        // Assert
        assertTrue(page.getSubmittedName().contains(name));
    }
}