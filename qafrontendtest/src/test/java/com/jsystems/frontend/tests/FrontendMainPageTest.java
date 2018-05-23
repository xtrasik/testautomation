package com.jsystems.frontend.tests;

import com.jsystems.frontend.Configuration;
import com.jsystems.frontend.FrontendConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.jsystems.frontend.pages.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FrontendMainPageTest extends FrontendConfig {

    MainPage mainPage;
    LoginPage loginPage;
    WebDriverWait wait;

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
        driver.get(Configuration.WORDPRESS_BASE_URL);
        mainPage = new MainPage(driver);
        mainPage.loginButton.click();

        loginPage = new LoginPage(driver);
        loginPage.emailFields.sendKeys(Configuration.WORDPRESS_EMAIL);
        loginPage.continueButton.click();

        loginPage.passwordFields.sendKeys(Configuration.WORDPRESS_PASSWORD);
        loginPage.submitButton.click();

    }
}

