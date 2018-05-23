package com.jsystems.frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="usernameOrEmail")
    public WebElement emailFields;

    @FindBy(css="button.button.form-button.is-primary")
    public WebElement submitButton;




}
