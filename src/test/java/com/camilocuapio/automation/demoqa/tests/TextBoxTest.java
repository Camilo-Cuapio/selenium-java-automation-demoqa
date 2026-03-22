package com.camilocuapio.automation.demoqa.tests;

import com.camilocuapio.automation.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxTest {

    private WebDriver driver;
    private TextBoxPage textBoxPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        textBoxPage = new TextBoxPage(driver);
        textBoxPage.visit("https://demoqa.com/text-box");
    }

    @Test
//Test data
    public void shouldSubmitFormSuccessfully() {
        String name = "Camilo Cuapio";
        String email = "cuapio.cami@gmail.com";
        String currentAddress = "Ciudad Nezahualcoyotl";
        String permanentAddress = "Estado de Mexico";
//Actions
        textBoxPage.textBoxForm();
        textBoxPage.clickSubmit();

        Assertions.assertTrue(textBoxPage.getOutputName().contains(name));
        Assertions.assertTrue(textBoxPage.getOutputEmail().contains(email));
        Assertions.assertTrue(textBoxPage.getOutputCurrentAddress().contains(currentAddress));
        Assertions.assertTrue(textBoxPage.getOutputPermananetAddress().contains(permanentAddress));
    }


}
