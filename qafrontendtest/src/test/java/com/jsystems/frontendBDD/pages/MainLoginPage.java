package com.jsystems.frontendBDD.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class MainLoginPage extends BasePage{


    public MainLoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement avatar = driver.findElement(By.cssSelector("a[data-tip-target=\"me\"]"));
    public WebElement mySite = driver.findElement(By.cssSelector("a[data-tip-target=\"my-sites\"] span"));

    public boolean isContentPresent(){
        assertTrue(avatar.isDisplayed());
        assertTrue(mySite.isDisplayed());
        return true;
    }
}
