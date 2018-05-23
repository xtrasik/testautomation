package com.jsystems.frontend.tests;

import com.jsystems.frontend.FrontendConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.jsystems.frontend.pages.*;

public class FrontendMainPageTest extends FrontendConfig {

    MainPage mainPage;
    LoginPage loginPage;

    @Test
    @DisplayName("Check content main page")
    public void contentMainPageTest(){
        driver.get("https://wordpress.com/");
        mainPage = new MainPage(driver);
        mainPage.isContentPresent();
    }

    @Test
    @DisplayName("Login Test")
    public void loginTest(){
        driver.get("https://wordpress.com/");
        mainPage = new MainPage(driver);
        mainPage.loginButton.click();

        loginPage = new LoginPage(driver);
        loginPage.emailFields.sendKeys("xtrasik@gmail.com");
    }
}

