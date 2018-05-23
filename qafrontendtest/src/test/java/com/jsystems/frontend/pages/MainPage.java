package com.jsystems.frontend.pages;

import com.jsystems.frontend.TestDataHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Page Object Pattern - dla każdej strony jest definiowana osobna klasa

public class MainPage {

    WebDriver driver;

    @FindBy(id = "navbar-login-link")
    public WebElement loginButton;

    @FindBy(id = "hero-cta")
    WebElement getStartedButton;

    @FindBy(css = "a#hero-plans-anchor.button.is-more-link.is-large")
    WebElement seePlanButton;

    @FindBy(css = "div.hp-hero__wrapper h1 span.no-widows")
    WebElement mainTextH1;

    @FindBy(css = "a[title=\"Websites\"]")
    WebElement checkLinkWebSites;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isContentPresent() {
        //  loginButton = driver.findElement(By.id("navbar-login-link")); --> to juz nie potrzebne jak uzywane PageFactory i inicjalizator@FindBy
        assertTrue(loginButton.isDisplayed());
        assertTrue(getStartedButton.isDisplayed());
        assertTrue(seePlanButton.isDisplayed());

        assertTrue(mainTextH1.isDisplayed());
        assertTrue(mainTextH1.getText().equals(TestDataHelper.wordPressMainText));

        assertTrue(checkLinkWebSites.isDisplayed());
        return true;

    }

}
