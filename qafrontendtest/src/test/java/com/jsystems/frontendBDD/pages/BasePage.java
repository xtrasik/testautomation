package com.jsystems.frontendBDD.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForVisibilityOfElement(WebElement element, int maxWaitTime){
        WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitMaxTime(Long time){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}